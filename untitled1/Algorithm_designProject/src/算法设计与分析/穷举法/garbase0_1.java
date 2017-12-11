package 算法设计与分析.穷举法;

/**
 * Created by Administrator on 2016/10/16 0016.
 */
//这道题是求幂集的
public class garbase0_1 {

    public static void main(String []args){
    int n=4,w=7;
    int [] ww={5,3,2,1};
    int [] vv={4,4,3,1};
    BPsetType p=new BPsetType();
        pset(n,p);
        System.out.println("0/1背包的求解方案");
        knap(p,ww,vv,w);

}
    public static void knap(BPsetType p,int w[],int v[],int W){
        int i,j;
        int sumw,sumv;
        int maxi=0 ,maxsumw=0,maxsumv=0;
        System.out.println("序列号"+"\t"+"选中的物品\t"+"总重量\t"+"总价值\t"+"能否装入");
        for(i=0;i<p.n;i++){
            System.out.print("    "+(i+1)+"\t");
            sumw=sumv=0;
            System.out.print("{ ");
            for(j=1;j<=p.data[i][0];j++){
                System.out.print(""+p.data[i][j]+"");
                sumw+=w[p.data[i][j]-1];
                sumv+=v[p.data[i][j]-1];
            }
            System.out.print("}\t\t\t"+sumw+"\t\t"+sumv+"\t\t");
            if(sumw<=W){
                System.out.print("能\n");
                if(sumv>sumw){
                    maxsumw=sumw;
                    maxsumv=sumv;
                    maxi=i;
                }
            }else

                System.out.println("否");


        }
        System.out.print("最佳解决方案");
        System.out.print("选中的物品");
        System.out.print("{");
        for(j=1;j<=p.data[maxi][0];j++)
            System.out.print(""+p.data[maxi][j]+"");
        System.out.print("},");
        System.out.print("总重量："+maxsumw+",总价值"+maxsumv);

    }
    public static void pset(int n,BPsetType p){
        int i,j,m;
        int a[]=new int[10];
        p.data[0][0]=0;p.n=1;
        for(i=1;i<=n;i++){
            m=p.n;
            for(j=0;j<m;j++){
                copy(p.data[j],a,p.data[j][0]);
            a[0]++;
                a[a[0]]=i;
                copy(a,p.data[p.n],a[0]);
            p.n++;
            }
        }
    }

    public static void copy(int a[],int b[],int m)
    {
        int i;
        for(i=0;i<=m;i++){
         b[i]=a[i];
         }
    }
    public static void disp(BPsetType p){
        int i,j,m;
        for(i=0;i<p.n;i++){
            System.out.print("{");
            for(j=1;j<=p.data[i][0];j++){
                System.out.print(p.data[i][j]);
            }
            System.out.print("}");
        }
    }

}
class BPsetType{
    public int [][]data=new int[1000][100];
    public int n;
}