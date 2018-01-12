/**
 * Created by Administrator on 2016/4/11 0011.
 */
public class PalindromeNum {
    public static void main(String []args){
        int i,j,t,k,s;
        int a,b,cc;
        char []c=new char[10];
        int []p=new int [1000];
        for(i=10;i<1000;i++){
        p[i]=i;


            if(i<100){
                a=i%10;
                b=i/10;
                if(a==b){
                    p[i]=i;
                    System.out.println(p[i]+" ");
                }

            }else if(i>=100&&i<1000){
                a=i/100;
             //   b=(i/10)%10;
                cc=i%10;
                if(a==cc){
                    p[i]=i;
                    System.out.println(p[i]+" ");
                }
            }
        }

    }
}
