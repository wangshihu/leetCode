package Ch201_220;

import com.huihui.util.ListNode;

/**
 * Created by hadoop on 2015/6/11 0011.
 */
public class Ch206 {
    public ListNode reverseList(ListNode head) {
        while(head==null||head.next==null)
            return head;
        ListNode pre = head;
        head = head.next;
        pre.next = null;
        while(head!=null){
            ListNode tempNext= head.next;
            head.next = pre;
            pre = head;
            head= tempNext;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode pre= head;
        for(int i=2;i<3;i++){
            ListNode node= new ListNode(i);
            pre.next =node;
            pre = node;
        }
        ListNode.printLinkedList(head);
        System.out.println();
        head = new Ch206().reverseList(head);
        ListNode.printLinkedList(head);
    }
}
