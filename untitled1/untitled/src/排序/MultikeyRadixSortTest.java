package 排序;

import java.util.Arrays;

/**
 * 第一步
 以LSD为例，假设原来有一串数值如下所示：
 73, 22, 93, 43, 55, 14, 28, 65, 39, 81
 首先根据个位数的数值，在走访数值时将它们分配至编号0到9的桶子中：
 0
 1  81
 2  22
 3  73 93 43
 4  14
 5  55 65
 6
 7
 8 28
 9 39
 第二步
 接下来将这些桶子中的数值重新串接起来，成为以下的数列：
 81, 22, 73, 93, 43, 14, 55, 65, 28, 39
 接着再进行一次分配，这次是根据十位数来分配：
 0
 1 14
 2 22 28
 3 39
 4 43
 5 55
 6 65
 7 73
 8 81
 9 93
 第三步
 接下来将这些桶子中的数值重新串接起来，成为以下的数列：
 14, 22, 28, 39, 43, 55, 65, 73, 81, 93
 这时候整个数列已经排序完毕；如果排序的对象有三位数以上，则持续进行以上的动作直至最高位数为止。
 LSD的基数排序适用于位数小的数列，如果位数多的话，使用MSD的效率会比较好。MSD的方式与LSD相反，
 是由高位数为基底开始进行分配，但在分配之后并不马上合并回一个数组中，而是在每个“桶子”中建立“
 子桶”，将每个桶子中的数值按照下一数位的值分配到“子桶”中。在进行完最低位数的分配后再合并回单一的数组中。
 * Created by Administrator on 2016/9/4 0004.
 */
class RadixSortTest {
    public static void main(String [] args){
    int []data=new int[]{110,192,221,12,23};
        print(data);
        radixSort(data,10,data.length-1);
        System.out.println("排序后的数组：");
        print(data);
    }
private  static void print(int [] data){
for(int i=0;i<data.length;i++){
    System.out.print(data[i]+"\t");
}
}
    private static void radixSort(int []data,int  radix,int d){
        int []tmp=new int[data.length];//缓存数组
        int []buckets=new int[radix];//buckets用于记录待排序元素的信息
        for(int i=0,rate=1;i<d;i++){//buckets数组定义了max-min个桶
            Arrays.fill(buckets,0);//将数组值都改成0
            System.arraycopy(data,0,tmp,0,4);//将data中的元素复制到tmp数组中 4表示最大的数有多少位
            for(int j=0;j<data.length;j++){//计算每个待排序的关键字
                int subKey=(tmp[j]/rate)%radix;
                buckets[subKey]++;
            }
            for(int j=1;j<radix;j++){
                buckets[j]=buckets[j]+buckets[j-1];
            }
            //按子关键字对指定的数据进行排序
            for(int m=data.length-1;m>=0;m--){
                int subKey=(tmp[m]/rate)%radix;
                data[--buckets[subKey]]=tmp[m];
            }
            rate*=radix;

        }
    }

}