package 排序;

/**
 * Created by Administrator on 2016/5/20 0020.
 */
public class MergeSortAndtwo {
    /**
     * 二路归并排序的递归算法-入口
     * @param <T>
     * @param t
     * @return
     */
    public static <T extends Comparable> boolean mergeSortRecursive(T[] t){
        if(t==null || t.length <= 1) return true;

        MSortRecursive(t, 0, t.length-1);

        return true;
    }

    /**
     * 二路归并排序的递归算法-递归主体
     * @param <T>
     * @param t
     * @param low
     * @param high
     * @return
     */
    private static <T extends Comparable> boolean MSortRecursive(T[] t, int low, int high){
        if(t==null || t.length <= 1 || low == high) return true;

        int mid = (low+high)/2;
        MSortRecursive(t, low, mid);
        MSortRecursive(t, mid+1, high);
        merge(t, low, mid ,high);

        return true;
    }

    /**
     * 2-路归并排序的非递归算法。
     * 算法思路：
     * 从归并段的长度为1开始，一次使归并段的长度变为原来的2倍。
     * 在每趟归并的过程中，要注意处理归并段的长度为奇数和
     * 最后一个归并段的长度和前面的不等的情况
     * @param <T>
     * @param t
     * @return
     */
    public static <T extends Comparable> boolean mergeSortNonRecursive(T[] t){
        if(t==null || t.length<=1) return true;

        int len = 1;
        //程序边界的处理非常重要
        while(len <= t.length){
            for(int i = 0 ; i+len<=t.length-1 ;i += len*2){
                int low = i, mid = i+len-1, high = i+len*2-1;
                if(high>t.length-1) high = t.length-1;
                merge(t, i, mid, high);
            }

            len *= 2;
        }
        return true;
    }


    /**
     * 将两个归并段合并成一个归并段
     * @param <T>
     * @param t
     * @param low
     * @param mid
     * @param high
     * @return
     */
    private static <T extends Comparable> boolean merge(T[] t, int low, int mid, int high){
        T[] s = t.clone();//先复制一个辅助数组

        int i, j, k;//三个指示器，i指示t[low...mid]，j指示t[mid+1...high]，k指示s[low...high]
        for(i=low, j=mid+1, k=low ; i<=mid && j<=high ; k++){
            if(t[i].compareTo(t[j]) <= 0){
                s[k] = t[i++];
            }else{
                s[k] = t[j++];
            }
        }

        //将剩下的元素复制到s中
        if(i <= mid){
            for( ; k <= high; k++){
                s[k] = t[i++];
            }
        }else{
            for( ; k<=high; k++){
                s[k] = t[j++];
            }
        }
        for(int m = low; m<=high ; m++){//将辅助数组中的排序好的元素复制回原数组
            t[m] = s[m];
        }

        return true;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{22,2,3,6,8,9,2,0,1};
        long startTime=System.currentTimeMillis();   //获取开始时间
        mergeSortNonRecursive(arr);
        long endTime=System.currentTimeMillis();   //获取开始时间
        System.out.println("执行时间："+(endTime-startTime));
        for(int i : arr){
            System.out.print(i+ " ");
        }
    }
}
