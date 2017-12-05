package 回溯算法;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/10/30 0030.
 */
public class ZeroOne {
    public static void main(String args[]){//输入数据
        Scanner input = new Scanner(System.in);
        int W=0,n=0;
        int bestp[]=new int[1]; bestp[0]=0;
        int P=0,c=0,cw=0,cp=0;
        n =4;
        c =7;
        int p[] ={0,9,10,7,4}, w[] = {0,3,5,2,1},add[]=new int[n+1];
        int px[] = new int[n+1], wx[] = new int[n+1];
        double mid[] = new double[n+1];

     //回溯法求其中一个最优解
        for(int i=1;i<=n;i++){//预先处理
            mid[i]=1.0*p[i]/w[i];
            P+=p[i];  W+=w[i];
            add[i]=i;
        }
        if(W<=c){
            System.out.print(bestp[0]);
            System.exit(0);
        }
        sort(mid,add);//用冒泡和地址排序
        for(int i=1;i<=n;i++){
            px[i]=p[add[i]]; wx[i]=w[add[i]];//使px的顺序按单位重量由高到低排列
        }
        Backtrack(1,n,cw,cp,bestp,c,px,wx);//输出最大价值
        System.out.print(bestp[0]);
    }
    public static void sort(double[] a,int[] add) {
        int temp = 0;
        for (int i = a.length-1; i > 0; --i) {
            for (int j = 1; j < i; ++j) {
                if (a[add[j + 1]] > a[add[j]]) {
                    temp = add[j];
                    add[j] = add[j + 1];
                    add[j + 1] = temp;
                }
            }
        }
    }
    public static void Backtrack(int i,int n,int cw,int cp,int bestp[],int c, int px[],int wx[]){//回溯法
        if(i>n)
        {  bestp[0] = cp; return;  }//这里十分麻烦，应该还有解决的办法//每次return之后bestp的值又会变回0；只有其为地址传递时才不会变为0；
        if(cw+wx[i]<=c){//进入左子树
            cw+=wx[i];
            cp+=px[i];
            Backtrack(i+1,n,cw,cp,bestp,c,px,wx);
            cw-=wx[i];//回退
            cp-=px[i];}
        if(Bound(i+1,n,cw,cp,c,px,wx)>bestp[0])//进入右子树
            Backtrack(i+1,n,cw,cp,bestp,c,px,wx);
    }
    public static int Bound(int i,int n,int cw,int cp,int c, int px[],int wx[]){//计算上界
        int cleft=c-cw;//剩余容量
        int b = cp;
        while(i<=n && wx[i]<=cleft){
            cleft -= wx[i];
            b+=px[i];
            i++;}
        if(i<=n)//装满背包
            b+=px[i]*cleft/wx[i];
        return b;//上界
    }
}
