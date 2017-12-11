package 九度;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/7/24 0024.
 */
public class BinarySearchRIght {
    public static void main(String[] args) {
        Scanner sin=new Scanner(System.in);
        int n=Integer.parseInt(sin.nextLine());
        String s=sin.nextLine();
        TreeNode t=buildTree(s);
        String a=preVisit(t);
        int count=0;
        while(count<n){
            String ss=sin.nextLine();
            count++;
            TreeNode t2=buildTree(ss);          //这个地方一定记得用t2把返回值接住，否则值没有返回，后面会有空指针异常
            String b=preVisit(t2);
            //System.out.println(b);
            if(a.equals(b))
                System.out.println("YES");
            else System.out.println("NO");
        }

    }
    private static String preVisit(TreeNode t) {

        StringBuilder sb=new StringBuilder();
        if(t==null)
            return null;
        else{
            sb.append(t.data);
            sb.append(preVisit(t.left));               //和前面一样，一定要把结果加入sb,利用sb.append，否则直接写preVisit(t.left)的话，
            //结果没有加入sb，只有根节点加入sb了，不对！
            sb.append(preVisit(t.right));
        }
        return sb.toString();
    }
    private static TreeNode buildTree(String s) {
        TreeNode t=null;
        for(int i=0;i<s.length();i++){
            t=insert(t,s.charAt(i)-'0');
        }
        return t;
    }

    public static TreeNode insert(TreeNode t,int data){
        if(t==null)
            return new TreeNode(data);
        if(data<t.data)
            t.left=insert(t.left, data);
        else if(data>t.data)
            t.right=insert(t.right,data);
        else
            ;
        return t;

    }
}


class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data){
        this.data=data;
    }
}
