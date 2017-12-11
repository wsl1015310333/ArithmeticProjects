package 排序;

/**
 * Created by Administrator on 2016/6/11 0011.
 */
public class BubbleSort {
    public static int    a[]={2,1,4,5,3,6,8,7,9};
    public static void main(String []args){

       BubbleSort(a,a.length-1);
      for(int i=0;i<a.length;i++){
          System.out.print(a[i]+" ");
      }
        System.out.println();
        BubbleSort1(a,a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
    //递jian排序
    public static void BubbleSort(int a[],int n){
        int i=0;
        for(i=0;i<n;i++){
            for(int j=0;j<n-i;j++){//注意这步  j必须为零 因为每次循环  都是排好 最后那个数组  前面还没排好序 j要为零
                    if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
    public static void BubbleSort1(int a[],int n){
        int i,j;
        boolean flag=false;
        for(i=0;i<n;i++){

            for( j=n;j>i;j--){//和上面相反

                if(a[j-1]<a[j]){
                    int temp=a[j];
                    a[j]=a[j-1];
                    a[j-1]=temp;
                    flag=true;
                }

            }
            if(flag==false){
                return ;
            }else{
                flag=false;
            }
        }
    }

}
