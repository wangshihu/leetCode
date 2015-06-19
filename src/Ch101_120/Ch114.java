package Ch101_120;

import com.huihui.util.TreeNode;

/**
 * Created by hadoop on 2015/6/5 0005.
 */
public class Ch114 {
    public void flatten(TreeNode root) {
        if(root==null)
            return ;
        doFlatten(root);
    }

    public TreeNode doFlatten(TreeNode node){
        if(node.left==null&&node.right==null)
            return node;
        TreeNode tempRight = node.right;
        TreeNode tempNode = node;
        if(node.left!=null){
            node.right = node.left;
            node.left = null;
            tempNode = doFlatten(node.right);
        }
        if(tempRight!=null){
            tempNode.right = tempRight;
            tempNode = doFlatten(tempRight);
        }
        return tempNode;
    }

    public static void main(String[] args) {
        int[] preorder = {1,2};
        int[] inorder = {2,1};
        TreeNode root = TreeNode.buildTree(preorder,inorder);
        new Ch114().doFlatten(root);
        System.out.println(root);
    }
}
