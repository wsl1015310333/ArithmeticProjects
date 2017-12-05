package 排序;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

/**
 * Created by Administrator on 2016/8/15 0015.
 */
public class TestSort {

    public static void main(String[] args) {
        int a[] = {4, 3, 2, 1, 0, 5, 6, 8, 7, 8};
        BubbleSort(a, a.length - 1);
//        for(int i=0;i<a.length;i++){
//            System.out.print(a[i]+" ");
//        }
        System.out.println("冒泡排序");
        int b[] = {4, 3, 9, 1, 0, 5, 3, 8, 7, 8};
        InsertSort(b, b.length - 1);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
        System.out.println("插入排序");
        int c[] = {4, 3, 9, 1, 0, 5, 3, 8, 7, 8};
        InsertSort(c, c.length - 1);
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
        System.out.println();
        System.out.println("选择排序");
        int d[] = {4, 3, 9, 1, 0, 5, 3, 8, 7, 8};
        SelectSort(d, d.length - 1);
        for (int i = 0; i < d.length; i++) {
            System.out.print(d[i] + " ");
        }
        System.out.println();
        System.out.println("shell序");
        int e[] = {4, 3, 9, 1, 0, 5, 3, 8, 7, 8};
        ShellSort(e, e.length - 1);
        for (int i = 0; i < e.length; i++) {
            System.out.print(e[i] + " ");
        }
    }


    public static void BubbleSort(int a[], int n) {
        boolean flag = true;
        for (int i = 0; i < n; i++) {

            for (int j = n - 1; j >= 0; j--) {

                if (a[j] < a[j + 1]) {
                    a[j] = a[j] + a[j + 1];
                    a[j + 1] = a[j] - a[j + 1];
                    a[j] = a[j] - a[j + 1];
                    flag = false;
                }
            }
            if (flag == true) {
                return;
            } else {
                flag = true;
            }
        }
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n-i;j++){
//                if(a[j]>a[j+1]){
//                    a[j]= a[j]+a[j+1];
//                    a[j+1]=a[j]-a[j+1];
//                    a[j]=a[j]-a[j+1];
//
//                }
//            }

    }

    public static void InsertSort(int a[], int n) {
        int i, j, t;
//    for( i=1;i<n;i++){
//     t=a[i];
//        for(j=i-1;j>=0&&t<a[j];j--)
//            a[j+1]=a[j];
//        a[j+1]=t;
//    }
        for (i = 1; i <= n; i++) {//降序
            t = a[i];
            for (j = i - 1; j >= 0 && t > a[j]; j--)
                a[j + 1] = a[j];
            a[j + 1] = t;
        }
    }

    public static void SelectSort(int a[], int n) {
        int i, j, t, k;
        for (i = 0; i < n; i++) {
            k = i;
            for (j = i + 1; j <= n; j++) {
                if (a[k] > a[j]) {
                    k = j;
                }

            }

            t = a[i];
            a[i] = a[k];
            a[k] = t;
        }
    }

    public static void ShellSort(int a[], int n) {
        int d, i, j, x;
        d = n / 2;
        while (d >= 1) {
            for (i = d; i <= n; i++) {
                x = a[i];
                j = i - d;
                while (j >= 0 && a[j] > x) {
                    a[j + d] = a[j];
                    j = j - d;
                }
                a[j + d] = x;
            }
            d = d / 2;
        }
    }

    public static <T extends Comparable> boolean mergeSortRevursive(T[] t) {
        if (t == null || t.length <= 1) return true;

        MSortRecursizve(t, 0, t.length - 1);
        return true;
    }

    public static <T extends Comparable> boolean MSortRecursizve(T[] t, int low, int high) {
        if (t == null || t.length <= 1 || low == high) return true;

        int mid = (low + high) / 2;
        MSortRecursizve(t, 0, mid);
        MSortRecursizve(t, mid + 1, high);
        Merge(t, low, mid, high);

        return true;
    }

    public static <T extends Comparable> boolean Merge(T[] t, int low, int mid, int high) {
        T[] s = t.clone();
        int i, j, k;
        for (i = low, j = mid + 1, k = low; i < mid && j <= high; k++) {
            if (t[i].compareTo(t[j]) <= 0) {
                s[k] = t[i++];
            } else {
                s[k] = t[j++];
            }
        }
        if (i <= mid) {
            for (; k <= high; k++) {
                s[k] = t[i++];
            }
        } else {
            for (; k < high; k++) {

                s[k] = s[j++];
            }
        }
        for (int m = low; m <= high; m++) {
            t[m] = s[m];
        }
        return true;
    }

    public static <T extends Comparable> boolean mersortNonRecursive(T[] t) {
        if (t == null || t.length <= 1) return true;
        int len = 1;
        while (len <= t.length) {
            for (int i = 0; i + len < t.length - 1; i += len * 2) {
                int low = i, mid = i + len - 1, high = i + len * 2 - 1;
                if (high > t.length - 1)
                    high = t.length - 1;
                Merge(t, i, mid, high);
            }
            len *= 2;
        }
        return true;
    }

    public static void QuickSort(int a[], int left, int right) {
        int i;
        if (left < right) {
            i = Division(a, left, right);
            QuickSort(a, left, i - 1);
            QuickSort(a, i + 1, right);
        }
    }

    public static int Division(int a[], int left, int right) {
        int base = a[left];
        while (left < right) {
            while (left < right && a[right] > base) {
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] < base) {
                left++;
            }
            a[right] = a[left];
        }
        return left;

    }

    public static void swap(int []data,int i,int j){
        if(i==j){
            return;
        }
        data[i]=data[i]+data[j];
        data[j]=data[i]-data[j];
        data[i]=data[i]-data[j];
    }
    public static void heapSort(int []data){
        for(int i=0;i<data.length;i++){
            createMaxHeap(data,data.length);
            swap(data,0,data.length-1-i);
            //print(data);
        }
    }
    public static void createMaxHeap(int []data,int lastIndex){
        for(int i=(lastIndex-1)/2;i>=0;i++){
            int k=i;
            while(2*k+1<=lastIndex){
                int biggerIndex=2*k+1;
                if(biggerIndex<lastIndex){
                    if(data[biggerIndex]<data[biggerIndex+1]){
                        biggerIndex++;
                    }
                }
                if(data[k]<data[biggerIndex]){
                    swap(data,k,biggerIndex);
                    k=biggerIndex;
                }else{
                    break;
                }
            }

        }
    }
}

