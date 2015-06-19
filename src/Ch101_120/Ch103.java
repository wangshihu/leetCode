package Ch101_120;

import com.huihui.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by hadoop on 2015/6/4 0004.
 */
public class Ch103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        List<List<Integer>> result = new ArrayList<>();
        boolean rightDirection = true;
        while(!stack.isEmpty()){
            int size = stack.size();
            List<Integer> tempList = new ArrayList<>();
            List<TreeNode> tmepNodeList = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode currentNode = stack.pop();
                tempList.add(currentNode.val);
                if(rightDirection){
                    if(currentNode.left!=null)
                        tmepNodeList.add(currentNode.left);
                    if(currentNode.right!=null)
                        tmepNodeList.add(currentNode.right);

                }else {
                    if(currentNode.right!=null)
                        tmepNodeList.add(currentNode.right);
                    if(currentNode.left!=null)
                        tmepNodeList.add(currentNode.left);
                }
            }
            stack.addAll(tmepNodeList);
            rightDirection = !rightDirection;
            result.add(tempList);
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
        List<List<Integer>> result = new Ch103().zigzagLevelOrder(root);
        System.out.println(result);
    }
}
