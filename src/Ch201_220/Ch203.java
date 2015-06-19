package Ch201_220;

import com.huihui.util.ListNode;

/**
 * Created by hadoop on 2015/6/11 0011.
 */
public class Ch203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode(-1);
        ListNode pre=  result;
        if(head==null)
            return null;
        while(head!=null){
            if(head.val!=val)
                pre.next=head;
            head = head.next;
            if(pre.next!=null){
                pre = pre.next;
                pre.next = null;
            }
        }
        pre.next = null;
        return  result.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(2);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode.printLinkedList(head);
        head = new Ch203().removeElements(head,2);
        System.out.println();
        ListNode.printLinkedList(head);
    }
}
