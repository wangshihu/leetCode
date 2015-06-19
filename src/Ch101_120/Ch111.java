package Ch101_120;

import com.huihui.util.TreeNode;

/**
 * Created by hadoop on 2015/6/5 0005.
 */
public class Ch111 {
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return 1;
        int leftLength = minDepth(root.left);
        int rightLength = minDepth(root.right);
        if(leftLength==0)
            return rightLength+1;
        if(rightLength==0)
            return leftLength+1;
        return Math.min(leftLength, rightLength)+1;
    }

}
