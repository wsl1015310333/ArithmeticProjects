package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/10/23 0023.
 */
public class Single_Number {
    public static void main(String []args){
        int a[]={1,1,2,4,2,5,6};
        System.out.println(singleNumber(a));
    }
    public static int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(nums[i])==false){
                map.put(nums[i],1);
            }
            else{
                map.remove(nums[i]);
            }
        }
        List<Integer> answer = new ArrayList<Integer>(map.keySet());
        return answer.get(0);

    }
}
