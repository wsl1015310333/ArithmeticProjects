package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/11 0011.
 */
public class _39CombinationSum {
    public static void main(String []args){
        int []a={2,3};
        int targer=7;
      List<List<Integer>> list=  combinationSum(a,targer);
        for(List aa :list){
            System.out.println(list.toString());
        }

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        helper(res, new ArrayList<>(), candidates, target, 0);

        return res;

    }

    private static void helper(List<List<Integer>> res, List<Integer> com, int[] candidates, int target, int start) {

        if(target < 0 || start >= candidates.length) {
            return;
        }
        if(target == 0) {
            res.add(new ArrayList<>(com));
            return;
        }

        for(int i = start; i < candidates.length; i++) {

            int num = candidates[i];
            com.add(num);
            helper(res, com,  candidates, target-num, i);
            com.remove(com.size()-1);
        }
    }
}
