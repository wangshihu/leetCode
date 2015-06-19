package Ch101_120;

import com.huihui.util.TreeNode;

/**
 * Created by hadoop on 2015/6/4 0004.
 */
public class Ch106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder==null||inorder==null||postorder.length!=inorder.length)
            return null;
        return doBuildTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1);

    }
    public TreeNode doBuildTree(int[] postorder, int b1,int e1,int[] inorder,int b2,int e2) {
        if(b1==e1)
            return new TreeNode(postorder[e1]);
        if(b1>e1||b2>e2)
            return null;
        int index= -1;
        for(int i=b2;i<=e2;i++){
            if(inorder[i]==postorder[e1])
                index = i;
        }
        TreeNode node = new TreeNode(postorder[e1]);
        TreeNode left = doBuildTree(postorder, b1, b1+index-b2-1, inorder, b2, index-1);
        TreeNode right = doBuildTree(postorder, b1+index-b2, e1-1, inorder, index+1, e2);
        node.left = left;
        node.right =right;
        return node;
    }
    public static void main(String[] args) {
        int[] postoder = {1,2,4,3,6,7,9,11,10,8,5};
        int[] inorder = {1,2,3,4,5,6,7,8,9,10,11};
        TreeNode root = new Ch106().buildTree(inorder,postoder);
        TreeNode.printPreorder(root);
        System.out.println();
        TreeNode.printInorder(root);
        System.out.println();
        TreeNode.printPoster(root);

    }
}
