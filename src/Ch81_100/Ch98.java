package Ch81_100;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2015/6/3 0003.
 */
public class Ch98 {//中序投机取巧过的- -。
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
    public boolean isValidBST(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        doInorderTraversal(root,result);
        for(int i=1;i<result.size();i++){
            if(result.get(i)<=result.get(i-1))
                return false;
        }
        return true;
    }

    public void doInorderTraversal(TreeNode root,List<Integer> list){
        if(root==null)
            return ;
        doInorderTraversal(root.left,list);
        list.add(root.val);
        doInorderTraversal(root.right,list);
    }
}
