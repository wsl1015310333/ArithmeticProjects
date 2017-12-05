package leetcode;

import java.util.HashMap;
/**
 * Created by Administrator on 2016/10/30 0030.
 */
public class _209_Isomorphic_Strings {
    public static void main(String []args){
        System.out.println(isIsomorphic("add","egg"));
        System.out.println(isIsomorphic("abcd","abcd"));
        System.out.println(isIsomorphic("adad","cpcb"));
    }
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap<Character,Character>();
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))!=null){
                if(t.charAt(i)!=map.get(s.charAt(i)))//Map.put(‘a’,’e’)//这个方法返回的是 如果之前没有放入key为d的就返回e，如果之前有就返回原先那个value
                    return false;
            }
            else{
                if(map.containsValue(t.charAt(i)))
                    return false;
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        System.out.println("--"+map.put('d','d'));
        return true;
    }

}
