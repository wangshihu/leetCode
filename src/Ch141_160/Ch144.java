package Ch141_160;

import com.huihui.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by hadoop on 2015/6/9 0009.
 */
public class Ch144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right!=null)
                stack.add(node.right);
            if(node.left!=null)
                stack.add(node.left);

        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.sortedArrayToBST(7);
        new Ch144().preorderTraversal(root);
    }
}
