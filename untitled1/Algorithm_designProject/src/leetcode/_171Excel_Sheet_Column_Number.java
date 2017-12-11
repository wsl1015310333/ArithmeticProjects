package leetcode;

/**
 * Created by Administrator on 2016/10/24 0024.
 */
public class _171Excel_Sheet_Column_Number {
    public static void main(String []args){
        System.out.println(titleToNumber("AAA"));
    }
    public static  int titleToNumber(String s) {
        int num = 0;
        int len = s.length();
        char c = 0;
        for (int i = 0; i < len; i++) {
            c = s.charAt(len-i-1);
            num += (int)Math.pow(26,i) * (c - 'A' + 1);
        }
        return num;
    }
}
