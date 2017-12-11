package leetcode;

/**
 * Created by Administrator on 2016/10/24 0024.
 */
public class _283Move_Zero_ {
    public static void main(String args[]){
        int a[]={0,1,0,2,3,4};
        moveZeroes(a);
    }

    public static void moveZeroes(int[] nums) {
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums [i];
            if (num == 0) zeroCount++;
            if (zeroCount > 0 && num != 0) {
                nums[i-zeroCount] = num;
                nums[i] = 0;
            }
        }
        for(int i=0;i<nums.length;i++)
        System.out.print(nums[i]+" ");
    }
}
