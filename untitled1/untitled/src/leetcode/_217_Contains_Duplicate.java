package leetcode;

import java.util.HashSet;

/**
 * Created by Administrator on 2016/10/25 0025.
 */
public class _217_Contains_Duplicate {
    public static void main(String []args){
        int a[]={1,2,3,4};
        int b[]={1,2,3,4,3};
        int c[]={1,2,3,3,3,4,4};
        System.out.println(containsDuplicate(a));
        System.out.println(containsDuplicate(b));
        System.out.println(containsDuplicate(c));
    }
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> map = new HashSet<Integer>();
        int i = 0;
        int j = nums.length-1;
        while(i <= j){
            if(nums[i] != nums[j]){
                if(map.contains(nums[j])){
                    return true;
                }else{
                    map.add(nums[j]);
                }
                if(map.contains(nums[i])){
                    return true;
                }else{
                    map.add(nums[i]);
                }
            }else if(nums[i] == nums[j] && i != j){
                return true;
            }else{
                if(map.contains(nums[j])){
                    return true;
                }else{
                    map.add(nums[j]);
                }
            }
            i++;
            j--;
        }
        return false;
    }
}
