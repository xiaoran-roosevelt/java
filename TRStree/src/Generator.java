import javafx.util.Pair;

import java.util.*;
//����TRS�ĸ���������Լ�����������������
class QueueRecord{
    public Node node=null;
    public Map<Double, Double> avg_host;
    public Map<Double, Double> avg_data;
}
public class Generator {
    //��Ⱥֵ����
    private  static  Double outlier_ratio=0.1;
    //     ���ĺ��ӽ�����,��Χ�ָ�
    private  static  int node_fanout=4;
    //   �������߶ȣ���������ѭ��
    private Integer max_height=3;
//     ����

    public  Node Construct()
    {
        Queue<QueueRecord> queue=new LinkedList<>();
//        ������Լ����ڵ���������������
        queue.offer(getData());
//        ��¼�����
        Node root=queue.peek().node;
        while (!queue.isEmpty()){
            QueueRecord qrd=queue.poll();
            Node node=qrd.node;
//            ���ݸýڵ��Ӧ�����ݣ��������Ϻ���
            Compute(qrd.avg_host,qrd.avg_data,node);
//            ��Ϻ�����̫��
            if(!Validate(qrd)){
//                �ָϸ��
                QueueRecord[] qrds=Split(qrd,node_fanout);
                for(int i=0;i<qrds.length;i++){
                    queue.offer(qrds[i]);
                }
            }
        }
//        ���ظ����
        return root;
    }
    //    ��ѯ,��ʱûƥ����Ŀ�ķ���ֵ,�����ڴ˺�����ӡ�鿴
//    ������ڵ㣬�Լ����ҷ�Χ����ö�Ӧ��host��Χ���Լ�һЩ��ɢֵ������
    public void LookUP(Node root,Double lb,Double ub){
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
//        ��ɢֵ
        Set<Pair<Double,Double>> outliers=new TreeSet<>();
//        host��Χ
        Set<Pair<Double,Double>> ranges =new TreeSet<>();
        while (!queue.isEmpty()){
            Node node=queue.poll();
            if(node.isLeaf()){
//                Ҷ�ӽ�㣬ֱ�ӻ�ȡ�ýڵ��Host��Χ����ɢֵ��������
                ranges.add(node.getHostRange());
                outliers.addAll(node.outliers);
            }else{
//                �ڲ���㣬�ҵ����������Χ��lb��ub���Ľ�㣬������ѯ
                for(int i=0;i<node.childList.size();i++){
                    if(node.childList.get(i).isCover(lb,ub)){
                        queue.offer(node.childList.get(i));
                    }
                }
            }
        }
    }
    //    ��Ϻ���Ч������,�����ֲ�ϸ��
    public QueueRecord[] Split(QueueRecord qrd,int node_fanout){
        Node node=qrd.node;
        if(node.getHeight()>=max_height){
            return new QueueRecord[0];
        }
        QueueRecord[] qrds=new QueueRecord[node_fanout];
//        ��ʱ�����㲻����Ҷ�ӽ��,�����ڲ����
        node.setLeaf(false);
//        ÿ���ֶεĴ�С
        double interval=(node.ub-node.lb)/node_fanout;
//        �Ժ��ӽ���ʼ��
        for (int i=0;i<node_fanout;i++){
            double lb=node.lb+i*interval;
            double ub=node.lb+i*interval+interval;
            Node newnode=new Node(lb,ub);
//            ������+1
            newnode.setHeight(node.getHeight()+1);
            node.childList.add(newnode);
            qrds[i]=new QueueRecord();
            qrds[i].node=newnode;
            Map<Double,Double> avg_data=new HashMap<>();
            Map<Double,Double> avg_host=new HashMap<>();
            for(Double key:qrd.avg_data.keySet()){
                Double value=qrd.avg_data.get(key);
//                ��ӷ�Χ�ڵ�����
                if(value>=lb && value<=ub){
                    avg_data.put(key,qrd.avg_data.get(key));
                    avg_host.put(key,qrd.avg_host.get(key));
                }
            }
//            ���º��ӽ�㷶Χ�ڵ�����
            qrds[i].avg_host=avg_host;
            qrds[i].avg_data=avg_data;
        }
        return qrds;
    }
    //    ��֤��Ϻ����Ƿ��㹻��
    public boolean Validate(QueueRecord qrd){
        for(Double key : qrd.avg_host.keySet()){
//            ���ڽ����Ϻ�����������Χ�ڣ���Ϊ��ɢֵ
            if(!qrd.node.InHostRange(qrd.avg_host.get(key))){
//                ��ɢֵ���������� target,��ʱ������ key
                qrd.node.outliers.add(new Pair<>(qrd.avg_data.get(key),key));
            }
            if(qrd.node.outliers.size()>outlier_ratio*qrd.avg_data.size()){
                return  false;
            }
        }
        return true;
    }
    //    ��Ϊ�������������ݿ���ȡ����,�Զ��庯��,�������ݳ�ʼ��
    public QueueRecord getData(){
        QueueRecord record=new QueueRecord();
//        ��ʼ������
        Map<Double,Double> host=new HashMap<>();
        Map<Double,Double> target=new HashMap<>();
        double lb=Double.MAX_VALUE;
        double ub=Double.MIN_VALUE;
//       ���ɷֶ����ݣ�ͬʱʹ�����������ʹ��������ɢ
        for(int i=1;i<100;i++){
            double hn=i*1.01;
            host.put(i*1.0,hn);
            double random=Math.random();
            double tn=0;
//            ���������ɢ
            if(random>0.5){
                tn=hn*(2+Math.random()*0.7);
            }else {
                tn=hn*(2-Math.random()*0.8);
            }
            target.put(i*1.0,tn);
//            ���������С
            lb=lb>tn?tn:lb;
            ub=ub<tn?tn:ub;
        }
//        ͬ��
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
//        ͬ��
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
//       ����
        record.avg_data=target;
        record.avg_host=host;
        record.node=new Node(lb,ub);
//        �����߶�Ϊ1
        record.node.setHeight(1);
        return record;
    }
    //    ��С���˷�������Ϻ���
    public void Compute(Map<Double, Double> avg_host, Map<Double, Double> avg_data, Node node) {
//        �п��������� û������
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
//                ����flag
                flag=1;
                continue;
            }
            Variance_data += ((value - EX_avg_data) * (value - EX_avg_data) - Variance_data) / (i + 1);
            i++;
        }
        Double cov=EX_host_mul_data-EX_avg_data*EX_avg_host;
        node.setBeta(cov/Variance_data);
        node.setAlpha(EX_avg_host-node.getBeta()*EX_avg_data);
//        ��Χ�ڵ���������,����epsilon����
        node.setCnt(avg_data.size());
//        ������������
        node.setEpsilon();
//        ����ͨ����Ϻ����������Host��Χ
        node.setHostRange();
    }
    //    ����TRS�����ҵ�����m��Χ��Ҷ�ӽ��
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
    //    ��TRS���в����µ�����
    public void insert(Node root,Double m,Double n,Double index){
        Node node =traverse(root,m);
        if(!node.InHostRange(n)){
            node.outliers.add(new Pair<>(m,index));
        }
    }
    //    ɾ��TRS���е�����
    public void delete(Node root,Double m,Double n,Double index){
        Node node=traverse(root,m);
        node.outliers.remove(new Pair<>(m,index));
    }
    //    ��α�����ӡ��
    public void printTree(Node node){
        Queue<Node> queue=new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            Node tnode=queue.poll();
            if(!tnode.isLeaf()){
                System.out.println("�ڲ����   "+"��Χ: "+tnode.lb+" - "+tnode.ub);
                for(int i=0;i<tnode.childList.size();i++){
                    queue.offer(tnode.childList.get(i));
                }
            }else{
                System.out.println("Ҷ�ӽ��   "+"target��Χ: "+tnode.lb+" - "+tnode.ub+" ��Ⱥ�㣺");
                for(Pair<Double,Double> pair:tnode.outliers){
                    System.out.println("target: "+pair.getKey()+"  ʱ������"+pair.getValue());
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
