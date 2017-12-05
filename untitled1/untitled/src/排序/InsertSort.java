package 排序;

/**
 * Created by Administrator on 2016/6/11 0011.
 */
public class InsertSort {
    public static int a[]={2,1,3,4,5,9,8,7};
    public static void main(String []args){
InsertSort(a,a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
    public static void InsertSort(int a[],int n){
        int i,j,t;
        for(i=1;i<=n;i++){
            t=a[i];
            for(j=i-1;j>=0&&t<a[j];j--){
             a[j+1]=a[j];

            }
            a[j+1]=t;
        }
    }
}