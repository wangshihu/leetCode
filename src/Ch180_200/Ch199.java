package Ch180_200;

import com.huihui.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by hadoop on 2015/6/11 0011.
 */
public class Ch199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode currentNode = queue.poll();
                if(i==size-1)
                    result.add(currentNode.val);
                if(currentNode.left!=null) {
                    queue.add(currentNode.left);
                }
                if(currentNode.right!=null)
                    queue.add(currentNode.right);
            }
        }
        return result;
    }
}
