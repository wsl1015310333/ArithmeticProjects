package 算法设计与分析.穷举法;

/**
 * Created by Administrator on 2016/10/16 0016.
 */
public class Miji {


        public static void main(String []args){
            int n=4,w=7;
            int [] ww={5,3,2,1};
            int [] vv={4,4,3,1};
            BPsetType1 p=new BPsetType1();
            pset(n,p);
            System.out.println("1-"+n+"的幂集如下：");
            disp(p);

        }
        public static void pset(int n,BPsetType1 p){
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
        public static void disp(BPsetType1 p){
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
    class BPsetType1{
        public int [][]data=new int[1000][100];
        public int n;
    }

