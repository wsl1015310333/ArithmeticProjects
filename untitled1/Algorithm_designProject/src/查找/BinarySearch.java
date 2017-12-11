package 查找;

/**
 * Created by Administrator on 2016/4/15 0015.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int p[] = new int[11];
        for (int i = 0; i < p.length; i++) {
            p[i] = i + 1;
            System.out.print(p[i]+" ");
        }

        int key = BinarySearch1(p, p.length, 8);
        System.out.println("查找出" + key);
    }

    public static int  BinarySearch1(int p[], int n, int key) {
        int height = n - 1, low = 0, c;
        while (low <= height) {
            c = (height + low) / 2;

            if (p[c] == key)
                return c;
            else if (key < p[c])
                height = c - 1;
            else if (p[c] < key)
                low = c + 1;

        }
       return 0;
    }
}
