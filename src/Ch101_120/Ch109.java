package Ch101_120;

import com.huihui.util.ListNode;
import com.huihui.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2015/6/5 0005.
 */
public class Ch109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        List<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        return doSortedArrayToBST(list,0,list.size()-1);
    }
    public TreeNode doSortedArrayToBST(List<Integer> list,int begin,int end){
        if(end<begin)
            return  null;
        if(end==begin)
            return new TreeNode(list.get(begin));
        int mid = (begin+end)/2;

        TreeNode node = new TreeNode(list.get(mid));
        TreeNode left = doSortedArrayToBST(list,begin,mid-1);
        TreeNode right = doSortedArrayToBST(list,mid+1,end);
        node.left = left;
        node.right = right;
        return node;
    }

    public static void main(String[] args) {
        int n=10;
        ListNode head = new ListNode(1);
        ListNode pre = head;
        for(int i=2;i<=n;i++){
            ListNode node=new ListNode(i);
            pre.next = node;
            pre = node;
        }
        TreeNode root = new Ch109().sortedListToBST(head);
        TreeNode.printInorder(root);
        System.out.println();
        TreeNode.printPreorder(root);
    }
}
