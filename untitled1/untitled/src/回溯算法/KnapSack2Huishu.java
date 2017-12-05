package 回溯算法;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/5/6 0006.
 */
public class KnapSack2Huishu {

    public static void main(String[] args)
    {

        Scanner in=new Scanner(System.in);
        System.out.println("Please enter the number of objects(请输入物品的数量):");
        int n=in.nextInt();
        int[] w=new int[n];
        int[] v=new int[n];
        System.out.println("Now,please enter the weight of these objects(现在请输入这些物品的重量):");
        for(int i=0;i<n;i++)
        {
            w[i]=in.nextInt();
        }
        System.out.println("Now,please enter the value of these objects(现在请输入这些物品的价值):");
        for(int i=0;i<n;i++)
        {
            v[i]=in.nextInt();
        }
        System.out.println("Now,please enter the capacity of the pack(现在请输入背包的容量):");
        int c=in.nextInt();
        /**
         *按单位重量价值r[i]=v[i]/w[i]降序排列
         */
        double startTime=System.currentTimeMillis();
        double[] r=new double[n];
        int[] index=new int[n];
        for(int i=0;i<n;i++)
        {
            r[i]=(double)v[i]/(double)w[i];
            index[i]=i;
        }
        double temp=0;
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(r[i]<r[j])
                {
                    temp=r[i];
                    r[i]=r[j];
                    r[j]=temp;
                    int x=index[i];
                    index[i]=index[j];
                    index[j]=x;
                }
            }
        }
        /**
         *排序后的重量和价值分别存到w1[]和v1[]中
         */
        int[] w1=new int[n];
        int[] v1=new int[n];
        for(int i=0;i<n;i++)
        {
            w1[i]=w[index[i]];
            v1[i]=v[index[i]];
        }

        System.out.println (Arrays.toString(w1));
        System.out.println (Arrays.toString(v1));
        /**
         *调用函数KnapSackBackTrack()，输出打印装完物品以后的最大价值
         */
        KnapSackBackTrack(w1,v1,w1.length,c);
        double endTime=System.currentTimeMillis();
        System.out.println("Basic Statements take(基本语句用时) "+(endTime-startTime)+" milliseconds!");
    }
    /**
     *用回溯法求0、1背包最大价值的函数定义
     */
    public static void KnapSackBackTrack(int[] w,int[] v,int n,int c)
    {
        int CurrentWeight=0;
        int CurrentValue=0;
        int maxValue=0;
        int i=0;
        while(i>=0)
        {
            if(CurrentWeight+w[i]<=c)
            {
                CurrentWeight+=w[i];
                CurrentValue+=v[i];
                i++;
            }
            else
                break;
        }
        if(i<n)
        {
            maxValue=CurrentValue;
            System.out.println("Now,the largest values of objects in the pack is(背包中物品的最大价值为):"+maxValue);
            return;
        }
        System.out.println("Now,the largest values of objects in the pack is(背包中物品的最大价值为):"+maxValue);
        return;
    }
}