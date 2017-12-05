package 九度;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/7/25 0025.
 */
public class 矩阵想加 {
    public static void main(String []args){
        int i,j;
        int k=0;
        int sum1=0,sum2=0;
        int a1[][]=new int [100][100];
        int a2[][]=new int [100][100];
        Scanner scanner=new Scanner(System.in);
        while((i=scanner.nextInt())!=0&&(j=scanner.nextInt())!=0){
            for(int n1=0;n1<i;n1++){
                for(int n2=0;n2<j;n2++){
                    a1[n1][n2]=scanner.nextInt();
                }
            }
            for(int n1=0;n1<i;n1++){
                for(int n2=0;n2<j;n2++){
                    a2[n1][n2]=scanner.nextInt();
                }
            }
            for(int n1=0;n1<i;n1++){
                for(int n2=0;n2<j;n2++){
                    sum1=sum1+a1[n1][n2]+a2[n1][n2];
                }
                if(sum1==0){
                    k++;
                }
                sum1=0;
            }
            for(int n2=0;n2<j;n2++){
                for(int n1=0;n1<i;n1++){
                    sum2=sum2+a1[n1][n2]+a2[n1][n2];
                }
                if(sum2==0)
                    k++;
                sum2=0;
            }
            System.out.println(k);
            k=0;
        }

    }
}
