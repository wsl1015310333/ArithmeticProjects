package leetcode;

import java.util.*;

/**
 * Created by Administrator on 2016/10/24 0024.
 */
public class _383Ransom_Note {
public static void main(String []args){
    System.out.println(canConstruct("a","b"));
    System.out.println(canConstruct("aa","bb"));
    System.out.println(canConstruct("aa","aab"));
    System.out.println(canConstruct("a","abc"));
}
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0;i<magazine.length();i++)
        {
            if(!map.containsKey(magazine.charAt(i)))
            {
                map.put(magazine.charAt(i),1);
            }
            else
            {
                map.put(magazine.charAt(i),map.get(magazine.charAt(i))+1);
            }
        }
        for(int i = 0;i<ransomNote.length();i++)
        {
            if(map.containsKey(ransomNote.charAt(i)))
            {
                map.put(ransomNote.charAt(i),map.get(ransomNote.charAt(i))-1);
            }
            else
            {
                return false;
            }
        }
        List<Integer> list = new ArrayList<Integer>(map.values());
        for(int num:list)
        {
            if(num<0)
            {
                return false;
            }
        }
        return true;
    }
}
