package 贪心算法;

/**
 * Created by Administrator on 2016/5/5 0005.
 */
public class Greedy {

    public static void main(String args[]){
       // int n=3;
          float M=50;
          float v[]={0,60,100,200};
          float w[]={0,10,20,30};
          int N=3;
        float x[]=new float[N+1];
        for(int i=1;i<=N;i++){
            System.out.println("背包价值"+v[i]+"重量"+w[i]);
        }
        sort1(M,N,v,w,x);
        System.out.println("转入背包为");
        for(int i=1;i<=N;i++){
            System.out.println(x[i]);
        }
    }

    public static void   sort1(float M,float n,float [] v, float[] w, float x[]) {
int i;
        for(i=1;i<=n;i++)
        {
            x[i]=0;
        }
        float c=M;
        for( i=1;i<=n;i++){
            if(w[i]>c){
                break;
            }
            x[i]=1;
            c-=w[i];
        }

if(i<=n){
    x[i]=c/w[i];
}

    }


}
