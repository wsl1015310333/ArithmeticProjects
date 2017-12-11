package 九度;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/7/26 0026.
 */
public class 逗号隔开A_B {
    public static  void main(String []args){
        Scanner scanner=new Scanner(new BufferedInputStream(System.in));
        String a=null,b=null;

        while(scanner.hasNext()) {
           // while(( a=scanner.nextLine())!=null&&(b=scanner.nextLine())!=null)
             a=scanner.next();
             b=scanner.next();

           String aaa="";
          //  StringBuffer aaa;

            String[] aa = a.split(",");
            String[] bb = b.split(",");
           // System.out.println(aa[1]);
            String bbb="";

            for(int i=0;i<aa.length;i++) {
                aaa+=aa[i];

            }
            for(int i=0;i<bb.length;i++) {

                bbb+=bb[i];
            }



//
//            int aaaa = Integer.valueOf(aaa);
//            int bbbb = Integer.valueOf(bbb);
            BigInteger aaaa=new BigInteger(aaa);
            BigInteger bbbb=new BigInteger(bbb);
            System.out.println(aaaa.add(bbbb).toString());
        }
    }
}
