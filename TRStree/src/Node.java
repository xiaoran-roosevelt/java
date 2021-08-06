import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Node{
    //    拟合函数的参数
    private Double beta;
    private Double alpha;
    private Double epsilon=0.0;
    private Double error_bound=2.0;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    private Integer height=0;
    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    private Integer cnt=0;
    //    结点target范围
    public Double lb;
    public Double ub;

    public void setEpsilon() {
        this.epsilon=(beta*(ub-lb)*error_bound)/(2*cnt);
    }

    //    结点通过函数拟合计算的Host范围，为叶子结点才有用
    private Double hostLb;
    private Double hostUb;
    //    结点的孩子结点，通过链表实现
    public LinkedList<Node> childList;
    //    标记叶子结点,默认为叶子,在进行分支的时候修改
    private boolean isLeaf=true;
    public boolean isLeaf() {
        return isLeaf;
    }
    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }
    //    放置 实际的Host值 不在通过拟合函数计算的范围内行的Target，和这行的索引tid,，也就是avg_data的key,时间序列的时间
    public Set<Pair<Double,Double>> outliers;
    public Node(Double lb, Double ub) {
        this.lb = lb;
        this.ub = ub;
        outliers=new HashSet<>();
        childList=new LinkedList<>();
    }
    //    判断实际的Host值是否在计算的范围内
    public boolean InHostRange(Double hostValue){
        if(hostValue >=hostLb && hostValue<=hostUb){
            return true;
        }
        return  false;
    }
    public boolean InTargetRange(Double targetValue){
        if(targetValue>=lb && targetValue<=ub){
            return true;
        }
        return  false;
    }
    //    在得到拟合函数后，更新Host范围
    public void setHostRange(){
        if(beta>=0){
            hostLb=beta*lb+alpha-epsilon;
            hostUb=beta*ub+alpha+epsilon;
        }else{
            hostLb=beta*ub+alpha-epsilon;
            hostUb=beta*lb+alpha+epsilon;
        }
    }
    //    返回拟合函数计算的Host范围，以Pair形式
    public Pair<Double,Double> getHostRange(){
        return new Pair<Double,Double>(hostLb,hostUb);
    }
    //   参数
    public void setBeta(Double beta) {
        this.beta = beta;
    }

    public void setAlpha(Double alpha) {
        this.alpha = alpha;
    }

    public Double getBeta() {
        return beta;
    }

    public Double getAlpha() {
        return alpha;
    }
    //    判断结点是否包含了查询的Target范围
    public boolean isCover(Double mlb,Double mub){
        if((mlb>=lb && mlb<=ub) ||
                (mub>=lb && mub<=ub)){
            return true;
        }
        return false;
    }
}