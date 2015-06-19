package Ch141_160;

import com.huihui.util.ListNode;

/**
 * Created by hadoop on 2015/6/9 0009.
 */
public class Ch147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode result = new ListNode(Integer.MIN_VALUE);
        while(head!=null){
            ListNode temp = result;
            while (temp.next!=null&&head.val>temp.next.val){
                temp = temp.next;
            }
            ListNode tempLast = temp.next;
            ListNode tempHead = head;
            head = head.next;
            temp.next = tempHead;
            tempHead.next = tempLast;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(7);
        ListNode node6 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        head = new Ch147().insertionSortList(head);
        ListNode.printLinkedList(head);
    }
}
