import java.util.Scanner;

/**
 * Created by Administrator on 2016/4/11 0011.
 */
public class Automorphic {
    public static void main(String []args){
        int faciend,num,mod,n_mod,p_mod;
        int i,t,n;
        System.out.println("输入最大的数");
        Scanner scanne=new Scanner(System.in);
        num=scanne.nextInt();
        System.out.println("1~"+num+"之间有一下自守数");
        for(i=11;i<num;i++) {
            faciend=i;
            mod=1;
            do {
                mod*=10;
                faciend/=10;
            }while(faciend>0);
            p_mod=mod;
            faciend=0;
            n_mod=10;
           // mod/=10;
            while(mod>0){
                t=i%(mod*10);
                n=t%n_mod-i%(n_mod/10);
                t=t*n;
                faciend=(faciend+t)%p_mod;
                mod/=10;
                n_mod*=10;
            }
            if(i==faciend){
                System.out.println("自树"+i);
            }
        }
    }

}
