package 九度;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/7/26 0026.
 */
public class Grading {

    public static void main(String[] args) {
        double P = 0, T = 0, G1 = 0, G2 = 0, G3 = 0, GJ = 0;
        Scanner scanner = new Scanner(System.in);





        while ((P = scanner.nextDouble()) != 0 && ( T = scanner.nextDouble()) != 0 && (G1 = scanner.nextDouble()) != 0 && (G2 = scanner.nextDouble()) != 0&&(G3 = scanner.nextDouble())!=0) {
            double grade = 0.0;

            if (Math.abs(G1 - G2) <= T) {
                grade = (G1 + G2) / 2;

            } else {
                if(Math.abs(G3-G2)<=T&&Math.abs(G3-G1)>T||Math.abs(G3-G2)>T&&Math.abs(G3-G1)<=T){
                    if(Math.abs(G3-G2)>Math.abs(G3-G2))
                        grade=(G3+G1)/2.0;
                    else
                        grade=(G3+G2)/2.0;
                }
                else if(Math.abs(G3-G2)<=T&&Math.abs(G3-G2)<=T)
                    grade=Math.max(Math.max(G1,G2),G3);
                else
                    grade=GJ;
            }
            System.out.println(grade);
        }
    }

}



