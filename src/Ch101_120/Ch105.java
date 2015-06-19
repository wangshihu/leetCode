package Ch101_120;

import com.huihui.util.TreeNode;

/**
 * Created by hadoop on 2015/6/4 0004.
 */
public class Ch105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null||preorder.length!=inorder.length)
            return null;
        return doBuildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);

    }
    public TreeNode doBuildTree(int[] preorder, int b1,int e1,int[] inorder,int b2,int e2) {
        if(b1==e1)
            return new TreeNode(preorder[b1]);
        if(b1>e1||b2>e2)
            return null;
        int index= -1;
        for(int i=b2;i<=e2;i++){
            if(inorder[i]==preorder[b1])
                index = i;
        }
        TreeNode node = new TreeNode(preorder[b1]);
        TreeNode left = doBuildTree(preorder, b1+1, index-b2+b1, inorder, b2, index-1);
        TreeNode right = doBuildTree(preorder, b1+index-b2+1, e1, inorder, index+1, e2);
        node.left = left;
        node.right =right;
        return node;
    }

    public static void main(String[] args) {
        int[] preorder = {5,3,2,1,4,8,7,6,10,9,11};
        int[] inorder = {1,2,3,4,5,6,7,8,9,10,11};
        TreeNode root = new Ch105().buildTree(preorder,inorder);
        TreeNode.printPreorder(root);
        System.out.println();
        TreeNode.printInorder(root);
        System.out.println();
        TreeNode.printPoster(root);

    }
}
