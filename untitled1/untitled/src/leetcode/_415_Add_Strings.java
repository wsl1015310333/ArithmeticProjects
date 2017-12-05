package leetcode;

/**
 * Created by Administrator on 2016/10/25 0025.
 */
public class _415_Add_Strings {
    public static void main(String []args){
        System.out.println(addStrings("10","33"));
    }
    public static String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        StringBuilder s=new StringBuilder();
        int sum=0,carry=0;

        while(len1>=0 || len2>=0) {
            int first = len1>=0 ? num1.charAt(len1)-'0' : 0;
            int second = len2>=0 ? num2.charAt(len2)-'0' : 0;
            sum = carry+first+second;
            s.insert(0,sum%10);
            carry = sum/10;
            len1--;
            len2--;
        }

        if(carry>0)
            s.insert(0,carry);


        return s.toString();
    }
}
