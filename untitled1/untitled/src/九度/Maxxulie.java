package 九度;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/7/23 0023.
 */
public class Maxxulie {
    public  static void main(String args[]){

        int in,max,x,y;

        Scanner scanner=new Scanner(System.in);
        while((in=scanner.nextInt())!=0){
         int a[]=new int[10001];
            int sum=0,i,j;
            for(i=0;i<in;i++){
                a[i]=scanner.nextInt();
            }
            max =a[0];
            x=1;
            y=1;
            for(i=0;i<in;i++) {
                sum=0;
             for(j=i;j<in;j++){
               sum+=a[j];
                       if(sum>max) {
                       max=sum;
                           x=i;
                           y=j;
                       }
                       }

            }
            System.out.println(max+" "+ a[x]+ " "+a[y]);
            }



    }

}
