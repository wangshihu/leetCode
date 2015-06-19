package Ch101_120;

import com.huihui.util.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hadoop on 2015/6/5 0005.
 */
public class Ch116 {
    public void connect(TreeLinkNode root) {
        if(root==null)
            return;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            TreeLinkNode preNode = null;
            for(int i=0;i<size;i++){
                TreeLinkNode currentNode = queue.poll();
                if(preNode!=null){
                    preNode.next = currentNode;
                }
                if(currentNode.left!=null)
                    queue.add(currentNode.left);
                if(currentNode.right!=null)
                    queue.add(currentNode.right);
                preNode = currentNode;
            }
        }
    }

    public static void main(String[] args) {
        TreeLinkNode root  = new TreeLinkNode(1);
        TreeLinkNode node1  = new TreeLinkNode(2);
        TreeLinkNode node2  = new TreeLinkNode(3);
        TreeLinkNode node3  = new TreeLinkNode(4);
        TreeLinkNode node4  = new TreeLinkNode(5);
        //TreeLinkNode node5  = new TreeLinkNode(6);
        TreeLinkNode node6  = new TreeLinkNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        //node2.left = node5;
        node2.right = node6;
        new Ch116().connect(root);
        System.out.println(root);
    }
}
