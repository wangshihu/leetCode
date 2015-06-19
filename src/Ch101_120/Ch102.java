package Ch101_120;

import com.huihui.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by hadoop on 2015/6/4 0004.
 */
public class Ch102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode currentNode = queue.poll();
                tempList.add(currentNode.val);
                if(currentNode.left!=null)
                    queue.add(currentNode.left);
                if(currentNode.right!=null)
                    queue.add(currentNode.right);
            }
            result.add(tempList);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left=node1;
        root.right=node2;
        node2.left=node3;
        node2.right =node4;
        List<List<Integer>> result = new Ch102().levelOrder(root);
        System.out.println(result);
    }
}
