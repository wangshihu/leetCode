package Ch101_120;

import com.huihui.util.TreeNode;

/**
 * Created by hadoop on 2015/6/5 0005.
 */
public class Ch112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        return doHasPathSum(root,sum,0);
    }
    public boolean doHasPathSum(TreeNode root, int sum,int cNum){
        cNum = cNum+ root.val;
        if(root.left==null&&root.right==null&&cNum==sum)
            return true;
        if(root.left!=null){
            if(doHasPathSum(root.left, sum, cNum))
                return true;
        }
        if(root.right!=null){
            if(doHasPathSum(root.right, sum, cNum))
                return true;
        }
        return false;
    }
}
