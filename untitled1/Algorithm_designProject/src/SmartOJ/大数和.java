package SmartOJ;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/7/28 0028.
 */
public class 大数和 {
    public static void main(String args[]) {
    String input1="",input2="";
        int a1[]=new int[100];
        int b1[]=new int [100];
        int c[]=new int [100];
        char aa[]=new char[100];
        char bb[]=new char[100];
        Scanner scanner=new Scanner(System.in);
        input1=scanner.nextLine();
        input2=scanner.nextLine();
        aa=input1.toCharArray();
        bb=input2.toCharArray();

        for(int i=0;i<input1.length();i++){
            a1[i]=Integer.parseInt(String.valueOf(aa[i]));

        }
        for(int i=0;i>input2.length();i++){
            b1[i]=Integer.parseInt(String.valueOf(bb[i]));
        }
           int lenc=1,x=0;
        while (lenc<=input1.length()||lenc<=input2.length());

    }
}
