package 九度;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/7/23 0023.
 */
public class MaxxulieRight {
    public static void main(String arg[]) {
        int n;
        Scanner scanner=new Scanner(System.in);
        while((n=scanner.nextInt())!=0) {
            int a[] = new int[10001];
            int sum[] = new int[10001];
            for(int i=0;i<a.length;i++){
                sum[i]=0;
            }

            int i, j;
            int s = 1, e = 1;
            for (i = 1; i <=n; i++){
                a[i]=scanner.nextInt();
                sum[i]=sum[i-1]+a[i];
            }
            int max=sum[1];
            for(i=1;i<=n;i++){
                for(j=i;j>=0;j--){
                    if(max<(sum[i]-sum[j])){
                        max=sum[i]-sum[j];
                        s=j+1;
                        e=i;
                    }

                }
            }
            if(max<0){
                System.out.println(a[1]+" "+a[n-1]);
            }else {
                System.out.println(max+" "+a[s]+" "+a[e]);
            }
        }
    }
}
