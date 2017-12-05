import java.util.Scanner;

/**
 * Created by Administrator on 2016/4/11 0011.
 */
public class GCDLCM1 {
    public static void main(String []args){
        int a,b;
        Scanner scanner=new Scanner(System.in);
        a=scanner.nextInt();
        b=scanner.nextInt();
        System.out.println("最大公约数"+GCD(a,b));
        System.out.println("最小公约数"+lcm(a,b));
    }

    private static int lcm(int a, int b) {
       // int m=a*b;
        int c=GCD(a,b);

        return (a*b)/c;
    }

    private static int GCD(int a,int b) {
        int c,m,n;
        m=a>=b?a:b;
        n=a<b?a:b;
    c=m%n;
        while(c!=0){
            m=n;
            n=c;
            c=m%n;
        }

        return n;
    }

}
