import javafx.util.Pair;

import java.util.*;
//构建TRS的辅助，结点以及结点包含的两列数据
class QueueRecord{
    public Node node=null;
    public Map<Double, Double> avg_host;
    public Map<Double, Double> avg_data;
}
public class Generator {
    //离群值比率
    private  static  Double outlier_ratio=0.1;
    //     结点的孩子结点个数,范围分割
    private  static  int node_fanout=4;
    //   树的最大高度，避免无限循环
    private Integer max_height=3;
//     建树

    public  Node Construct()
    {
        Queue<QueueRecord> queue=new LinkedList<>();
//        根结点以及根节点包含的数据先入队
        queue.offer(getData());
//        记录根结点
        Node root=queue.peek().node;
        while (!queue.isEmpty()){
            QueueRecord qrd=queue.poll();
            Node node=qrd.node;
//            根据该节点对应的数据，计算出拟合函数
            Compute(qrd.avg_host,qrd.avg_data,node);
//            拟合函数不太好
            if(!Validate(qrd)){
//                分割，细化
                QueueRecord[] qrds=Split(qrd,node_fanout);
                for(int i=0;i<qrds.length;i++){
                    queue.offer(qrds[i]);
                }
            }
        }
//        返回根结点
        return root;
    }
    //    查询,暂时没匹配项目的返回值,可以在此函数打印查看
//    输入根节点，以及查找范围，获得对应的host范围，以及一些离散值的索引
    public void LookUP(Node root,Double lb,Double ub){
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
//        离散值
        Set<Pair<Double,Double>> outliers=new TreeSet<>();
//        host范围
        Set<Pair<Double,Double>> ranges =new TreeSet<>();
        while (!queue.isEmpty()){
            Node node=queue.poll();
            if(node.isLeaf()){
//                叶子结点，直接获取该节点的Host范围和离散值，做并集
                ranges.add(node.getHostRange());
                outliers.addAll(node.outliers);
            }else{
//                内部结点，找到包含这个范围（lb，ub）的结点，继续查询
                for(int i=0;i<node.childList.size();i++){
                    if(node.childList.get(i).isCover(lb,ub)){
                        queue.offer(node.childList.get(i));
                    }
                }
            }
        }
    }
    //    拟合函数效果不佳,继续分层细化
    public QueueRecord[] Split(QueueRecord qrd,int node_fanout){
        Node node=qrd.node;
        if(node.getHeight()>=max_height){
            return new QueueRecord[0];
        }
        QueueRecord[] qrds=new QueueRecord[node_fanout];
//        此时这个结点不再是叶子结点,而是内部结点
        node.setLeaf(false);
//        每个分段的大小
        double interval=(node.ub-node.lb)/node_fanout;
//        对孩子结点初始化
        for (int i=0;i<node_fanout;i++){
            double lb=node.lb+i*interval;
            double ub=node.lb+i*interval+interval;
            Node newnode=new Node(lb,ub);
//            结点深度+1
            newnode.setHeight(node.getHeight()+1);
            node.childList.add(newnode);
            qrds[i]=new QueueRecord();
            qrds[i].node=newnode;
            Map<Double,Double> avg_data=new HashMap<>();
            Map<Double,Double> avg_host=new HashMap<>();
            for(Double key:qrd.avg_data.keySet()){
                Double value=qrd.avg_data.get(key);
//                添加范围内的数据
                if(value>=lb && value<=ub){
                    avg_data.put(key,qrd.avg_data.get(key));
                    avg_host.put(key,qrd.avg_host.get(key));
                }
            }
//            更新孩子结点范围内的数据
            qrds[i].avg_host=avg_host;
            qrds[i].avg_data=avg_data;
        }
        return qrds;
    }
    //    验证拟合函数是否足够好
    public boolean Validate(QueueRecord qrd){
        for(Double key : qrd.avg_host.keySet()){
//            不在结点拟合函数计算结果范围内，即为离散值
            if(!qrd.node.InHostRange(qrd.avg_host.get(key))){
//                离散值缓冲区保存 target,和时间索引 key
                qrd.node.outliers.add(new Pair<>(qrd.avg_data.get(key),key));
            }
            if(qrd.node.outliers.size()>outlier_ratio*qrd.avg_data.size()){
                return  false;
            }
        }
        return true;
    }
    //    因为不是真正从数据库表获取数据,自定义函数,进行数据初始化
    public QueueRecord getData(){
        QueueRecord record=new QueueRecord();
//        初始的数据
        Map<Double,Double> host=new HashMap<>();
        Map<Double,Double> target=new HashMap<>();
        double lb=Double.MAX_VALUE;
        double ub=Double.MIN_VALUE;
//       生成分段数据，同时使用随机函数，使得数据离散
        for(int i=1;i<100;i++){
            double hn=i*1.01;
            host.put(i*1.0,hn);
            double random=Math.random();
            double tn=0;
//            上下随机离散
            if(random>0.5){
                tn=hn*(2+Math.random()*0.7);
            }else {
                tn=hn*(2-Math.random()*0.8);
            }
            target.put(i*1.0,tn);
//            更新最大最小
            lb=lb>tn?tn:lb;
            ub=ub<tn?tn:ub;
        }
//        同上
        for(int i=100;i<200;i++){
            double hn=i*1.01;
            host.put(i*1.0,hn);
            double random=Math.random();
            double tn=0;
            if(random>0.5){
                tn=hn*(-3+Math.random()*0.7);
            }else {
                tn=hn*(-2-Math.random()*0.8);
            }
            target.put(i*1.0,tn);
            lb=lb>tn?tn:lb;
            ub=ub<tn?tn:ub;
        }
//        同上
        for(int i=200;i<300;i++){
            double hn=i*1.01;
            host.put(i*1.0,hn);
            double random=Math.random();
            double tn=0;
            if(random>0.5){
                tn=hn*(5+Math.random()*0.7);
            }else {
                tn=hn*(5.5-Math.random()*0.8);
            }
            target.put(i*1.0,tn);
            lb=lb>tn?tn:lb;
            ub=ub<tn?tn:ub;
        }
//       更新
        record.avg_data=target;
        record.avg_host=host;
        record.node=new Node(lb,ub);
//        根结点高度为1
        record.node.setHeight(1);
        return record;
    }
    //    最小二乘法计算拟合函数
    public void Compute(Map<Double, Double> avg_host, Map<Double, Double> avg_data, Node node) {
//        有可能区间内 没有数据
        if(avg_data.size()==0){
            return;
        }
        Double cov_host_data=0.0;
        Double EX_avg_host=0.0;
        Double EX_avg_data=0.0;
        Double EX_host_mul_data=0.0;
        Double Variance_data=0.0;
        int flag=0;
        int i=1;
        for(Double key : avg_host.keySet()) {
            if (flag == 0) {
                EX_avg_host = avg_host.get(key);
                EX_avg_data=avg_data.get(key);
                EX_host_mul_data=EX_avg_host*EX_avg_data;
                flag = 1;
                continue;
            }
//            System.out.print(value);
            EX_avg_host += (avg_host.get(key) - EX_avg_host) / (i + 1);

            EX_avg_data += (avg_data.get(key) - EX_avg_data) / (i + 1);

            EX_host_mul_data += (avg_host.get(key)*avg_data.get(key) - EX_host_mul_data) / (i + 1);
            i++;
        }
        flag=0;i=1;
        for(Double value:avg_data.values()) {
            if (flag == 0) {
                Variance_data = (value - EX_avg_data) * (value - EX_avg_data);
//                更改flag
                flag=1;
                continue;
            }
            Variance_data += ((value - EX_avg_data) * (value - EX_avg_data) - Variance_data) / (i + 1);
            i++;
        }
        Double cov=EX_host_mul_data-EX_avg_data*EX_avg_host;
        node.setBeta(cov/Variance_data);
        node.setAlpha(EX_avg_host-node.getBeta()*EX_avg_data);
//        范围内的数据总数,计算epsilon有用
        node.setCnt(avg_data.size());
//        设置置信区间
        node.setEpsilon();
//        更新通过拟合函数计算出的Host范围
        node.setHostRange();
    }
    //    遍历TRS树，找到包含m范围的叶子结点
    public Node traverse(Node node,Double m){
        if(node.isLeaf()){
            return node;
        }else {
            for(int i=0;i<node.childList.size();i++){
                if(node.childList.get(i).InTargetRange(m)){
                    return traverse(node.childList.get(i),m);
                }
            }
        }
        System.out.println("Error in Traverse");
        return null;
    }
    //    向TRS树中插入新的数据
    public void insert(Node root,Double m,Double n,Double index){
        Node node =traverse(root,m);
        if(!node.InHostRange(n)){
            node.outliers.add(new Pair<>(m,index));
        }
    }
    //    删除TRS树中的数据
    public void delete(Node root,Double m,Double n,Double index){
        Node node=traverse(root,m);
        node.outliers.remove(new Pair<>(m,index));
    }
    //    层次遍历打印树
    public void printTree(Node node){
        Queue<Node> queue=new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            Node tnode=queue.poll();
            if(!tnode.isLeaf()){
                System.out.println("内部结点   "+"范围: "+tnode.lb+" - "+tnode.ub);
                for(int i=0;i<tnode.childList.size();i++){
                    queue.offer(tnode.childList.get(i));
                }
            }else{
                System.out.println("叶子结点   "+"target范围: "+tnode.lb+" - "+tnode.ub+" 离群点：");
                for(Pair<Double,Double> pair:tnode.outliers){
                    System.out.println("target: "+pair.getKey()+"  时间索引"+pair.getValue());
                }
            }
        }
    }
    public static void main(String[] args) {
        Generator test=new Generator();
        Node root=test.Construct();
        test.printTree(root);
    }
}
