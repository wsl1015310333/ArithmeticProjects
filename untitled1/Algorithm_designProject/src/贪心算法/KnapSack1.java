package 贪心算法;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.nio.channels.Pipe;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/5/6 0006.
 * 背包问题
 */
public class KnapSack1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the number of objects");
        int n=in.nextInt();
        int []w=new int[n];
        int []v=new int[n];
        System.out.println("Now ,please enter the weight of these objects");
        for(int i=0;i<n;i++){
            w[i]=in.nextInt();
        }
        System.out.println("Now please enter the value of these objects");
        for(int i=0;i<n;i++){
            v[i]=in.nextInt();
        }
        System.out.println("Now please enter the capacity of the pack");
        int c=in.nextInt();
        /**
         * 按照单位重量价值r[i]=v[i]/w[i]降序排序
         */
        double starTime=System.currentTimeMillis();
        double []r=new double[n];
        int []index=new int[n];
        for(int i=0;i<n;i++){
            r[i]=(double)v[i]/w[i];
            index[i]=i;
        }
        double temp=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(r[i]<r[j]){
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
         * 排序后的重量和价值分别存到w[]和v[]中
         */
        int []w1=new int[n];
        int []v1=new int[n];
        for(int i=0;i<n;i++){
            w1[i]=w[index[i]];
            v1[i]=v[index[i]];
        }
        System.out.println(Arrays.toString(w1));
        System.out.println(Arrays.toString(v1));

        double []x=new double[n];
int iq;
        for( iq=0;iq<n;iq++){
            if(w1[iq]>c)
                break;
         //   if(w1[iq]<c) {
                x[iq] = 1;
                c = c - w1[iq];
        //    }

        }

        if(iq<n) {
            x[iq] =(double) c / w1[iq];//一定要加上double，不然都是为0
        }

        System.out.println("The solution vector is:"+Arrays.toString(x));

        double maxValue=0;
        for(int i=0;i<n;i++){
            if(x[i]==1){
                maxValue+=v1[i];
            }
            if(x[i]>0&&x[i]<1){
                maxValue+=x[i]*v1[i];
            }


        }
        double endTime=System.currentTimeMillis();
        System.out.println("Now,the latgest values of object of objects int the pack is"+maxValue);
        System.out.println("Basic Statements take"+(endTime-starTime)+" millseconds");
    }
}
