package leetcode;

/**
 * Created by Administrator on 2016/10/27 0027.
 */
public class _66_Puls_one {
    public static void main(String []args){
        int b[]={10,9,-2,1,8};
        int []a=plusOne(b);
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
    }
    public static int[] plusOne(int[] digits) {
        int num = digits.length-1;
        return recur(digits,num);
    }
    public static int[] recur(int[] digits,int num)
    {
        if(digits[num]<9)
        {
            digits[num]++;
            return digits;
        }
        if(digits[num] == 9)
        {
            digits[num] = 0;
        }
        if(num == 0)
        {
            int[] newdi = new int[digits.length+1];
            for(int i = 1;i<newdi.length;i++)
            {
                newdi[i] = digits[i-1];
            }
            newdi[0] = 1;
            return newdi;
        }
        return recur(digits,--num);
    }
}
