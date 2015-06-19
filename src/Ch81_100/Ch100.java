package Ch81_100;


import com.huihui.util.TreeNode;

/**
 * Created by hadoop on 2015/6/4 0004.
 */
public class Ch100 {


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)
            return true;
        if(p==null||q==null)
            return false;
        if(p.val!=q.val)
            return false;
        if(!isSameTree(p.left,q.left))
            return false;
        if(!isSameTree(p.right,q.right))
            return false;
        return true;
    }
}
