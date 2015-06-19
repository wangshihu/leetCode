package Ch101_120;

import com.huihui.util.TreeNode;

/**
 * Created by hadoop on 2015/6/4 0004.
 */
public class Ch104 {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
       return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left=node1;
        root.right=node2;
        node2.left=node3;
        node2.right =node4;
        System.out.println(new Ch104().maxDepth(root));
    }
}
