package 九度;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/8/20 0020.
 */
/*
题目描述：
    某省调查城镇交通状况，得到现有城镇道路统计表，表中列出了每条道路直接连通的城镇。省政府“畅通工程”的目标是使全省任何两个城镇间都可以实现交通（但不一定有直接的道路相连，只要互相间接通过道路可达即可）。问最少还需要建设多少条道路？

输入：
    测试输入包含若干测试用例。每个测试用例的第1行给出两个正整数，分别是城镇数目N ( < 1000 )和道路数目M；随后的M行对应M条道路，每行给出一对正整数，分别是该条道路直接连通的两个城镇的编号。为简单起见，城镇从1到N编号。
    注意:两个城市之间可以有多条道路相通,也就是说
    3 3
    1 2
    1 2
    2 1
    这种输入也是合法的
    当N为0时，输入结束，该用例不被处理。

输出：
    对每个测试用例，在1行里输出最少还需要建设的道路数目。

样例输入：
4 2
1 3
4 3
3 3
1 2
1 3
2 3
5 2
1 2
3 5
999 0
0
样例输出：
1
0
2
998
 */
    //这道题调试 写出相应的值就行
public class MainText {
public static int a[]=new int[1000];
  public static void main(String []args){
      int n,m;
      Scanner in=new Scanner(System.in);
      while(in.hasNext()&& (n=in.nextInt())!=0){
          m=in.nextInt();
          for(int i=0;i<=n;i++){
              a[i]=-1;//初始时，所有节点都是孤立的集合，及所在的集合只有一个节点其身就在所在的输的根节点
          }
          for(int i=0;i<m;i++)//读入边信息
          {
           int x,y;
              x=in.nextInt();
              y=in.nextInt();
              x=findRoot(x);//查找边的两个顶点所在的集合信息
              y=findRoot(y);
              if(x!=y)a[x]=y;//如两个顶点不在同一个集合，则合并这两个集合
          }
          int sum=0;
          for(int i=1;i<=n;i++){//统计所有节点中根节点的个数
              if(a[i]==-1)sum++;
          }
          System.out.println(sum-1);//答案即为 在ans个集合间在修建sum-1条道路即可
      }
  }
    public static int findRoot(int k) {//查找某个节点所在的树的根节点，并查集
        //找到元素的祖先元素a[k]
        if (a[k] == -1) return k;
        else {
       int tmp=findRoot(a[k]);
            a[k]=tmp;
            return tmp;
        }
    }

}
