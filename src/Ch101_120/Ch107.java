package Ch101_120;

import com.huihui.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by hadoop on 2015/6/4 0004.
 */
public class Ch107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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

        for(int i=0,j=result.size()-1;i<j;i++,j--){
            List<Integer> temp = result.get(i);
            result.set(i,result.get(j));
            result.set(j,temp);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node1_1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node3_1 = new TreeNode(12);
        TreeNode node3_2 = new TreeNode(13);
        TreeNode node4 = new TreeNode(7);
        TreeNode node4_1 = new TreeNode(8);
        TreeNode node4_2 = new TreeNode(9);
        root.left=node1;
        root.right=node2;
        node1.left = node1_1;
        node2.left=node3;
        node2.right =node4;
        node3.left = node3_1;
        node3.right = node3_2;
        node4.left = node4_1;
        node4.right = node4_2;
        List<List<Integer>> result = new Ch107().levelOrderBottom(root);
        System.out.println(result);
    }
}
