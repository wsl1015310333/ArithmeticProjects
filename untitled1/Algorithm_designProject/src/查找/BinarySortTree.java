package 查找;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/15 0015.
 */
public class BinarySortTree {
private  TreeNode root=null;
    private List<TreeNode> nodeList=new ArrayList<TreeNode>();
    private class TreeNode{
        private int key;
        private TreeNode leftChild;
        private TreeNode rightChild;
        private TreeNode parent;
      public   TreeNode(int key,TreeNode leftChild ,TreeNode rightChild ,TreeNode parent){
            this.key=key;
            this.leftChild=leftChild;
            this.rightChild=rightChild;
          this.parent=parent;
        }

        public int getKey(){
            return key;
}
        public String toString(){
            String leftkey=(leftChild==null?"":String.valueOf(leftChild.key));
            String rigthkey=(rightChild==null?"":String.valueOf(rightChild.key));
            return "("+leftkey+","+rigthkey+")";
        }

}
    public boolean isEmpty(){
        if(root==null){
            return true;

        }else{
            return false;
        }
    }
public void TreeEmpty() throws  Exception{
    if(isEmpty()){
        throw new Exception("树为空!");
    }
}
   public TreeNode search(int key){
       TreeNode pNode=root;
       while(pNode!=null&&pNode.key!=key){
           if(key<pNode.key){
               pNode=pNode.leftChild;
           }else{
               pNode=pNode.rightChild;
           }
       }
   return pNode;
   }
    public TreeNode minElemNode(TreeNode node) throws Exception {
        if(node==null){
            throw new Exception("树为空！");

        }
        TreeNode pNode=node;
        while(pNode.leftChild!=null){
            pNode=pNode.leftChild;
        }
        return pNode;
    }
public TreeNode maxElemNode(TreeNode node) throws Exception {
    if(node==null){
        throw new Exception("树为空！");
    }
    TreeNode pNode=node;
    while(pNode.rightChild!=null){
        pNode=pNode.rightChild;
     }
    return pNode;
}

    public TreeNode successor(TreeNode  node) throws  Exception{
        if(node==null){
            return null;
        }
        if(node.rightChild!=null){
            return minElemNode(node.rightChild);
        }
        TreeNode parentNode=node.parent;
        while(parentNode!=null&&node==parentNode.rightChild){
            node=parentNode;
            parentNode=parentNode.parent;
        }
        return parentNode;
    }
    public TreeNode precessor(TreeNode node)throws  Exception{
        if(node==null){
            return null;
        }
        if (node.leftChild!=null){
            return maxElemNode(node.leftChild);
        }
        TreeNode parentNode=node.parent;
        while (parentNode!=null&&node==parentNode.leftChild){
            node=parentNode;
            parentNode=parentNode.parent;
        }
        return parentNode;
    }


    public static void main(String []args){

    }

}
