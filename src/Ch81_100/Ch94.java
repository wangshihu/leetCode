package Ch81_100;


import com.huihui.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2015/6/3 0003.
 */
public class Ch94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        doInorderTraversal(root,result);
        return  result;
    }
    public void doInorderTraversal(TreeNode root,List<Integer> list){
        if(root==null)
            return ;
        doInorderTraversal(root.left,list);
        list.add(root.val);
        doInorderTraversal(root.right,list);
    }
}
