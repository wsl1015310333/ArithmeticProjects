package leetcode;

/**
 * Created by Administrator on 2016/10/25 0025.
 */
public class _387First_Unique_Charater_in_a_String {
    public static void main(String []args){
        System.out.println(longestPalindrome("abb"));
    }
    public static int longestPalindrome(String s) {
        int[] count = new int[Math.abs('A' - 'z')+1];
        int ans = 0;
        for(int i = 0; i< s.length(); i++) count[s.charAt(i) - 'A']++;
        for(int n: count) ans += n/2;
        return Math.min(ans*2+1, s.length());
    }
}
