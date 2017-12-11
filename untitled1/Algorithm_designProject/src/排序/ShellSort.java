package 排序;

import jdk.nashorn.tools.Shell;

/**
 * Created by Administrator on 2016/6/11 0011.
 */
public class ShellSort {
    public static int a[]={2,1,4,3,5,9,6,8,7};
    public static void main(String []agrs){
        ShellSort(a,a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
    public static void ShellSort(int a[],int n){
        int d,i,j,x;
        d=n/2;
        while(d>=1){
            for(i=d;i<=n;i++){
                x=a[i];
                j=i-d;
                while(j>=0&&a[j]>x){
                    a[j+d]=a[j];
                    j=j-d;//小于0 用来变成最小那边的数组
                }
                a[j+d]=x;//类似加法交换两个数 但是有所不同 这里提前保存了一个数组，不能用a[i],因为在while中已经改变了
            }
            d/=2;
        }

    }
}
