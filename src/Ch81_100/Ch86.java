package Ch81_100;

import com.huihui.util.ListNode;


/**
 * Created by hadoop on 2015/6/2 0002.
 */
public class Ch86 {
    public ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode(-1);
        ListNode pre1 = head1;
        ListNode head2 = new ListNode(-1);
        ListNode pre2 = head2;
        while (head!=null){
            if(head.val>=x){
                pre2.next = head;
                pre2 = head;
            }else{
                pre1.next = head;
                pre1 = head;
            }
            head = head.next;
        }
        pre1.next = head2.next;
        pre2.next = null;
        return head1.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(1);
        node3.next = node4;
        ListNode node5 = new ListNode(4);
        node4.next = node5;
        head=null;
        head = new Ch86().partition(head,3);

        ListNode.printLinkedList(head);
    }
}
