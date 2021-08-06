import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Node{
    //    ��Ϻ����Ĳ���
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
    //    ���target��Χ
    public Double lb;
    public Double ub;

    public void setEpsilon() {
        this.epsilon=(beta*(ub-lb)*error_bound)/(2*cnt);
    }

    //    ���ͨ��������ϼ����Host��Χ��ΪҶ�ӽ�������
    private Double hostLb;
    private Double hostUb;
    //    ���ĺ��ӽ�㣬ͨ������ʵ��
    public LinkedList<Node> childList;
    //    ���Ҷ�ӽ��,Ĭ��ΪҶ��,�ڽ��з�֧��ʱ���޸�
    private boolean isLeaf=true;
    public boolean isLeaf() {
        return isLeaf;
    }
    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }
    //    ���� ʵ�ʵ�Hostֵ ����ͨ����Ϻ�������ķ�Χ���е�Target�������е�����tid,��Ҳ����avg_data��key,ʱ�����е�ʱ��
    public Set<Pair<Double,Double>> outliers;
    public Node(Double lb, Double ub) {
        this.lb = lb;
        this.ub = ub;
        outliers=new HashSet<>();
        childList=new LinkedList<>();
    }
    //    �ж�ʵ�ʵ�Hostֵ�Ƿ��ڼ���ķ�Χ��
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
    //    �ڵõ���Ϻ����󣬸���Host��Χ
    public void setHostRange(){
        if(beta>=0){
            hostLb=beta*lb+alpha-epsilon;
            hostUb=beta*ub+alpha+epsilon;
        }else{
            hostLb=beta*ub+alpha-epsilon;
            hostUb=beta*lb+alpha+epsilon;
        }
    }
    //    ������Ϻ��������Host��Χ����Pair��ʽ
    public Pair<Double,Double> getHostRange(){
        return new Pair<Double,Double>(hostLb,hostUb);
    }
    //   ����
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
    //    �жϽ���Ƿ�����˲�ѯ��Target��Χ
    public boolean isCover(Double mlb,Double mub){
        if((mlb>=lb && mlb<=ub) ||
                (mub>=lb && mub<=ub)){
            return true;
        }
        return false;
    }
}