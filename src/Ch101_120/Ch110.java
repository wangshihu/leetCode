package Ch101_120;

import com.huihui.util.TreeNode;

/**
 * Created by hadoop on 2015/6/5 0005.
 */
public class Ch110 {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        return doIsBalanced(root)==-1;
    }

    public int doIsBalanced(TreeNode root) {
        if(root==null)
            return 0;
        int left = doIsBalanced(root.left);
        int right = doIsBalanced(root.right);
        if(left==-1||right==-1||Math.abs(left-right)>1){
            return -1;
        }else
            return Math.max(left,right)+1;
    }
}
