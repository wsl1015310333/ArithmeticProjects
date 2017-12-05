/**
 * Created by Administrator on 2016/4/11 0011.
 */
public class PrimeNum {
//    public static void main(String[]args){
//        int i,j,c=0;
//
//        System.out.println("1到1000的素数有");
//        for(i=3;i<1000;i++){
//            c=i;
//            for(j=2;i<c;j++){
//                if(c/j==0){
//                    continue;
//                }else{
//                    System.out.println(c+"为素数");
//               //     System.out.println("xianz");
//                }
//            }
//        }
//    }
    static  int   primeNum(int i){
        int j,flag=1;
        for(j=2;j*j<i-1;j++){
            if(i%j==0){
                flag=0;
                break;
            }
        }
        return flag;
    }
    public static void main(String []args){
        int i,j,c=0;
        int p[]=new int [1001];
        for(i=2;i<=1000;i++){
            p[i]=1;
        }
        for(i=3;i<=1000;i++){
            p[i]=primeNum(i);
        }
        for(i=2;i<1000;i++){
            if(p[i]==1){
                System.out.print(i+" ");
                c++;
                if(c%10==0){
                    System.out.println();
                }
            }
        }
    }
}
