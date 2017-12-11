package 九度;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/7/28 0028.
 */
public class Median_1004 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = null, b = null;
        String[] split,split1;
        String str1 = " ", str2 = " ";
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        while (scanner.hasNext()) {
            a = scanner.nextLine();
            b = scanner.nextLine();

            split = a.split(" ");
            int[] input = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                input[i] = Integer.valueOf(split[i]);
                list1.add(input[i]);

            }
            int re = find(input);

            split1 = b.split(" ");
            int []input1=new int[split1.length];
            for (int i = 0; i < split1.length; i++) {
                input1[i] = Integer.valueOf(split1[i]);
                list2.add(input1[i]);
            }
            int ret = find(input1);

            System.out.println((re+ret)/2);
        }

    }

    public static int find(int[] a) {
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = a.length - 1; j > i; j--) {
                if (a[j - 1] > a[j]) {
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;

                }
            }



        }

        if (a.length % 2 == 0)
            return Math.max(a[(a.length  / 2)-1],a[a.length/2]);
        else
            return a[a.length / 2];
    }

}
