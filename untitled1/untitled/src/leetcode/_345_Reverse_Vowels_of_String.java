package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2016/10/27 0027.
 */
public class _345_Reverse_Vowels_of_String {
    public static void main(String []args){
        System.out.println( reverseVowels("leetcode"));

    }
    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length-1;
        while(j > i){
            if(isVowel(s.charAt(i))){
                while(!isVowel(s.charAt(j))){
                    j--;
                }

                if(j > i){
                    chars[j] = s.charAt(i);
                    chars[i] = s.charAt(j);
                    j--;
                }
            }
            i++;
        }
        return new String(chars);
    }

    public static boolean isVowel(Character c){
        if(Character.toLowerCase(c) == 'a' ||
                Character.toLowerCase(c) == 'e'||
                Character.toLowerCase(c) == 'i'||
                Character.toLowerCase(c) == 'o'||
                Character.toLowerCase(c) == 'u')
            return true;

        return false;
    }

}
