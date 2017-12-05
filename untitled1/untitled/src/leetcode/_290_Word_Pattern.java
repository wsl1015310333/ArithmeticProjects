package leetcode;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/10/30 0030.
 */
public class _290_Word_Pattern {
    public static void main(String args[]){
        System.out.println(wordPattern("abba","dog cat cat dog"));
        System.out.println(wordPattern("abba","dog cat cat fish"));
    }
public static boolean wordPattern(String pattern,String str){
    char[] s=pattern.toCharArray();
    String  []t=str.split(" ");
    HashMap<Character,String > map=new HashMap<Character,String>();
    for(int i=0;i<s.length;i++){
        if(map.get(s[i])!=null){
            if(t[i]!=map.get(s[i]))//Map.put(‘a’,’e’)//这个方法返回的是 如果之前没有放入key为d的就返回e，如果之前有就返回原先那个value
                return false;
        }
        else{
            if(map.containsValue(t[i]))
                return false;
            map.put(s[i],t[i]);
        }
    }
    //System.out.println("--"+map.put('d','d'));
    return true;

}
}
