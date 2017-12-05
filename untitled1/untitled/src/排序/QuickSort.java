package 排序;

/**
 * Created by Administrator on 2016/6/11 0011.
 */
//调试错误
public class QuickSort {
    public static int a[]={2,1,4,3,5,6,9,8,7};
public static void main(String []args){
QuickSort1(a,0,a.length-1);
    for(int i=0;i<a.length-1;i++)
        System.out.print(a[i]+" ");
}
    public static int  Division(int a[],int left,int right){
        int base=a[left];
        while(left<right){
            while(left<right&&a[right]>base){
                --right;
            }
            a[left]=a[right];
            while(left<right&&a[left]<base){
                ++left;
            }
            a[right]=a[left];
        }
        a[left]=base;
        return left;
    }
    public static  void QuickSort1(int a[],int left,int right){
        int i;
        if(left<right){
            i=Division(a,left,right);
            QuickSort1(a, left, i-1);
            QuickSort1(a, i+1, right);
        }
    }
}
