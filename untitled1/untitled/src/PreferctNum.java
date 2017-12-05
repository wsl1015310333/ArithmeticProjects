import java.util.Scanner;

/**
 * Created by Administrator on 2016/4/10 0010.
 */
public class PreferctNum {
    public static void main(String []args){
//        System.out.println("");
//        Scanner scanner=new Scanner(System.in);
       // long p[]=new long[30];
        long[] p;
        p=new  long [30];
        int  i,num,cout,s,c=0;

for( num=2;num<1000;num++){
    s=num;
    cout=0;
    for(i=1;i<num;i++){
        if(s%i==0){
            p[cout++]=i;
           s-=i;
        }
    }
if(s==0){
    System.out.print(num+"是一个完数，因子是");
    System.out.println(num+"="+p[0]);
    for(i=1;i<cout;i++){
        System.out.print("+"+p[i]);
    }
    c++;
}
    System.out.println("共找到"+c+"个完数");
}


    }

}
