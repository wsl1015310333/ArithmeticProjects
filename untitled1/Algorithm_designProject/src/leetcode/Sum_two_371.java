package leetcode;

/**
 * Created by Administrator on 2016/10/23 0023.
 */
public class Sum_two_371 {
    public static void main(String args[]){
        System.out.println(add(3,5));
    }
    public static int add(int num1,int num2){
        int sum=0,carry=0;
        do{
            sum=num1^num2;
            carry=(num1&num2)<<1;
            num1=sum;
            num2=carry;
    }while (num2!=0);
    return num1;
    }

}
