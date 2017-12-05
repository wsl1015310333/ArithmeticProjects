package 九度;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/7/24 0024.
 */
public class Binary_tree {

public static char s[]=new char [100];
    public static int a[]=new int[100];
    public static int b[]=new int [100];
    public static void createTreee(char []s,int a[]){
        int j,n=s.length;
        int i=0;
        while(i<n) {
            for(j=0;j<100;){
                if(a[j]==-1){
                    a[j]=s[i]-'0';
                    break;
                }
                else{
                    if(a[j]>s[i]-'0')
                        j=2*j;
                        else
                        j=2*j+1;

                }
            }
        i++;
        }

    }

    public static void main(String []args){
      int i,j,n,m;
        String ss;
        Scanner scanner=new Scanner(System.in);
        while((n=scanner.nextInt())!=0) {
            ss = scanner.nextLine();
            s = ss.toCharArray();

            for (i = 1; i < 100; i++)
                a[i] = -1;
            createTreee(s, a);
    }
           for(int ii=0;ii<=n;ii--){
               String s1;
             s1=scanner.nextLine();
               s=s1.toCharArray();
               for(i=1;i<100;i++)
                   b[i]=-1;
               createTreee(s,b);
                   for (i = 0; i < 100; i++)
                       if (a[i] != b[i])
                           break;
                   if (i == 100)
                       System.out.println("YES");
                   else
                       System.out.println("NO");

           }


    }
}
