package Ch81_100;

import com.huihui.util.ListNode;


/**
 * Created by hadoop on 2015/6/2 0002.
 */
public class Ch83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(-1);
        ListNode pre = result;
        if(head==null)
            return null;
        int cNum = -9999;
        int num = 0;
        while(head!=null ){
            if(head.next!=null){
                if(cNum!=head.val){
                    pre.next = head;
                    pre = head;
                    cNum = head.val;
                    num = 0;
                }else{
                    num++;
                }
            }else {
                if(cNum==head.val){
                    num ++;
                }else{
                    pre.next = head;
                    num =0;
                }
            }
            head = head.next;
        }
        if(num>0)
            pre.next = null;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        head.next = node1;
        ListNode node2 = new ListNode(2);
        node1.next = node2;
//        ListNode node3 = new ListNode(3);
//        node2.next = node3;
//        ListNode node4 = new ListNode(4);
//        node3.next = node4;
//        ListNode node5 = new ListNode(4);
//        node4.next = node5;

        head = new Ch83().deleteDuplicates(head);

        ListNode.printLinkedList(head);
    }
}
