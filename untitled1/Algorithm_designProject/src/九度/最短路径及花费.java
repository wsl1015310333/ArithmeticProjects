package 九度;

import java.io.BufferedInputStream;
import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/7/25 0025.
 */
public class 最短路径及花费 {
    static int arr[][];
    static int cost[][];
    static int dist[];
    static int money[];
    static boolean isOK[];
    static int n;
    static int m;
    static final int  MAX = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedInputStream(System.in));
        while(s.hasNextInt()){
            n = s.nextInt();
            m = s.nextInt();
            if(n==0 && m==0)
                break;
            arr = new int[n][n];
            cost = new int[n][n];
            dist = new int[n];
            money = new int[n];
            isOK = new boolean[n];
            for(int[] a:arr)//都设置为最大值
                Arrays.fill(a, MAX);
            for(int[] a:cost)
                Arrays.fill(a, MAX);
            for(int i=0; i<m; i++){
                int a = s.nextInt()-1;
                int b = s.nextInt()-1;
                int c = s.nextInt();
                int d = s.nextInt();
                if(c < arr[a][b] ){ //如果有更小的路径  则更新
                    arr[a][b] = c;//第一个节点 为o
                    arr[b][a] = c;
                    cost[a][b] = d;
                    cost[b][a] = d;
                }
                if( c == arr[a][b] && d<cost[a][b]){
                    cost[a][b] = d;
                    cost[b][a] = d;
                }
            }

            int start = s.nextInt()-1;
            int end = s.nextInt()-1;
            if(start == end)
                System.out.println("0 0");
            dij(start,end);
            System.out.println(dist[end]+" "+money[end]);

            for(int i:dist)
                System.out.print(" "+i);
            System.out.println();
            for(int i:money)
                System.out.print(" "+i);
            System.out.println();

        }
    }
    static void dij(int start,int end){
        for(int i=0; i<n; i++){
            dist[i] = arr[start][i];  //初始化dist
            money[i] = cost[start][i];
        }
        int index = start;
        for(int i=0; i<n; i++){  //外层循环，依次找出到各个点的最短距离
            if(i==start)
                continue;
            int min = MAX;
            for(int j=0; j<n; j++)
                if(!isOK[j] && dist[j] < min){  //找到最短路径的顶点
                    min = dist[j];
                    index = j;
                }
            isOK[index] = true;
            if(isOK[end]) //如果以找到到终点的最短路径，返回
                break;

            for(int k=0; k<n; k++){  //更新 dist[] 和  money[]
                if(k==start)
                    continue;
                if( !isOK[k] && arr[index][k] != MAX){
                    int temp = arr[index][k]+dist[index];
                    int temp2 =cost[index][k] + money[index];
                    if(temp < dist[k]){
                        dist[k] = temp;
                        money[k] = temp2;
                    }else if(temp == dist[k] && (money[k] > temp2)){
                        money[k] = temp2;
                    }

                }
            }


        }
    }
}
