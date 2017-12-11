package 分支界限;

import java.util.PriorityQueue;

/**
 * Created by wsl on 2017/12/5 0005.
 */
/*
本代码实现了运用优先队列分支界限算法解决了01背包问题，解决问题的大致是思想和回溯2算法大致相同去，都属于搜索算法
，不过实现方式上有所不同，对于直
对于子集合问题，利用优先队列式分子界限算法的关键之一就是要确定优先级的设定，
在本代码中，优先级设定为了个节点
能够取到的价值上限。对于顺找剩余物品达最高上界，按照背包中剩余的空间依次去剩下的物品，
当空间不足取下一物品时，则将下一个物品的单位重量价值折算到剩下的空间中去
计算理想最高上界。计算出某个节点的上界。比较上界和已经找到的最大值之间的关系，
当然，首先要背包中的物品按照单位重量价值进行排序，放便于后面右子树的剪枝操作
在本代码中，省略了排序过程，在初始化物品的重量和价值，已经按照单位重量的价值排好了序

剪枝函数
对于像左搜索，可以通过是否超过背包容量和该节点价值上界能否超过最大值进行剪枝
对于向右搜索，则可以用其父节点的上界减去本层物品的价值，则可得到右边节点的上界

 */

//定义节点中的参数以及优先级设置的对象
class thingNode implements Comparable<thingNode>{
    int weight;//该节点目前背包中的重量
    double value;//该节点目前背包中的总价值
    double upprofit;//该节点能够达到的价值上界
    int Left;   //该节点是否属于左节点（用于最终构造最优解）
    int level;  //该节点是第几个物品的选择
    thingNode father; //该节点的父节点
    public int compareTo(thingNode node){
        if(this.upprofit<node.upprofit)
            return 1;
        else if(this.upprofit == node.upprofit)
            return 0;
        else
            return -1;
    }

}
public class Bag{
    int n = 5;
    int capacity = 10;
    int[] weight = {2,6,4,1,5};
    double[] value = {6,9,6,1,4};
    int maxValue = 0;
    int[] bestWay = new int[n];
    public void getMaxValue(){
        PriorityQueue<thingNode> pq = new PriorityQueue<thingNode>();
        //构造一个初始化节点，属于-1层
        thingNode initial = new thingNode();
        initial.level = -1;
        initial.upprofit = 26;
        pq.add(initial);
        while(!pq.isEmpty()){
            thingNode fatherNode = pq.poll();
            //当已经搜索到叶子节点时
            if(fatherNode.level == n-1){
                if(fatherNode.value > maxValue){
                    maxValue = (int)fatherNode.value;
                    for(int i=n-1;i>=0;i--){
                        bestWay[i] = fatherNode.Left;
                        fatherNode = fatherNode.father;
                    }
                }
            }
            else{
                //先统计其左节点信息，判断是否加入队列。
                if(weight[fatherNode.level+1]+fatherNode.weight <= capacity){
                    thingNode newNode = new thingNode();
                    newNode.level = fatherNode.level+1;
                    newNode.value = fatherNode.value + value[fatherNode.level+1];
                    newNode.weight = weight[fatherNode.level+1]+fatherNode.weight;
                    newNode.upprofit = Bound(newNode);
                    newNode.father = fatherNode;
                    newNode.Left = 1;
                    if(newNode.upprofit > maxValue)
                        pq.add(newNode);
                }
                //向右节点搜索，其能够取到的价值上界通过父亲节点的上界减去本层物品的价值。
                if((fatherNode.upprofit - value[fatherNode.level+1])> maxValue){
                    thingNode newNode2 = new thingNode();
                    newNode2.level = fatherNode.level+1;
                    newNode2.value = fatherNode.value;
                    newNode2.weight = fatherNode.weight;
                    newNode2.father = fatherNode;
                    newNode2.upprofit = fatherNode.upprofit - value[fatherNode.level+1];
                    newNode2.Left = 0;
                    pq.add(newNode2);
                }

            }
        }
    }
    //用于计算该节点的最高价值上界
    public double Bound(thingNode no){
        double maxLeft = no.value;
        int leftWeight = capacity - no.weight;
        int templevel = no.level;
        //尽力依照单位重量价值次序装剩余的物品
        while(templevel <= n-1 && leftWeight > weight[templevel] ){
            leftWeight -= weight[templevel];
            maxLeft += value[templevel];
            templevel++;
        }
        //不能装时，用下一个物品的单位重量价值折算到剩余空间。
        if( templevel <= n-1){
            maxLeft += value[templevel]/weight[templevel]*leftWeight;
        }
        return maxLeft;
    }
    public static void main(String[] args){
        Bag b = new Bag();
        b.getMaxValue();
        System.out.println("该背包能够取到的最大价值为:"+b.maxValue);
        System.out.println("取出的方法为:");
        for(int i : b.bestWay)
            System.out.print(i+"  ");
    }
}

