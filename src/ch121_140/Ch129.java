package ch121_140;

import com.huihui.util.TreeNode;

/**
 * Created by hadoop on 2015/6/5 0005.
 */
public class Ch129 {
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        return doSumNumbers(root,0);
    }
    public int doSumNumbers(TreeNode node,int cNum){
        cNum = cNum+node.val;
        if(node.left==null&&node.right==null)
            return cNum;
        int result = 0;
        if(node.left!=null)
            result += doSumNumbers(node.left,cNum*10);
        if(node.right!=null)
            result += doSumNumbers(node.right,cNum*10);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.sortedArrayToBST(7);
        System.out.println(new Ch129().sumNumbers(root));
    }
}
