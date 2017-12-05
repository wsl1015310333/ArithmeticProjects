package 排序;

/**
 * Created by Administrator on 2016/6/11 0011.
 */
public class SelectionSort {
    public static int a[]={2,1,4,3,5,6,9,8,7};
    public static void main(String []args){
        SelesctSort1(a,a.length-1);
        for(int i=0;i<a.length-1;i++){
            System.out.print(a[i]+" ");
        }
    }
    public static void SelesctSort1(int a[],int n){
        int i,j,t,k;
        for(i=0;i<n;i++){
            k=i;
            for(j=i+1;j<n;j++){
                if(a[k]>a[j])
                    k=j;
            }
            t=a[i];
            a[i]=a[k];
            a[k]=t;
        }
    }
}
