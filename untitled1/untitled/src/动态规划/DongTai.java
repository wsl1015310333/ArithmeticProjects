package 动态规划;

/**
 * Created by Administrator on 2016/4/21 0021.
 */
public class DongTai {//据称连城
  public static  int p[]= new int []{3,5,1,6,5,7};
 public static  int m[][]=new int [7][7];
    public static int s[][]=new int [7][7];
    public static void main(String []args) {

        System.out.println(MatrixChain(p,p.length,m,s));
    }
public static int MatrixChain(int p[],int n,int m[][],int s[][]) {
    int i,r;//m是最优值,s是最优值的断开点的索引,n为题目所给的矩阵的个数(下面例子中)
    for( i=1;i<=n;i++){//矩阵段长度为1,则m[][]中对角线的值为0,表示只有一个矩阵,没有相乘的.
        m[i][i]=0;
    }

    for( r=2;r<=n;r++){//r表示矩阵的长度(2,3…逐渐变长)
        for( i=1;i<=n-r+1;i++){//从第i个矩阵Ai开始,长度为r,则矩阵段为(Ai~Aj)
            int j=r+i-1;////当前矩阵段(Ai~Aj)的起始为Ai,尾为Aj
            //求(Ai~Aj)中最小的,其实k应该从i开始，但些处先记录第一个值，k从i+1开始，这样也可以。
            m[i][j]=m[i+1][j]+p[i-1]*p[i]*p[j];
            s[i][j]=i;
            for( int k=i+1;k<j;k++) {
                int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                if (t < m[i][j]) {
                    m[i][j] = t;
                    s[i][j] = k;
                }


            }
        }
    }
    return m[1][i-1];
}
    }

