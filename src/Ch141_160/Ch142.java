package Ch141_160;

import com.huihui.util.ListNode;

/**
 * Created by hadoop on 2015/6/9 0009.
 */
public class Ch142 {
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        ListNode p1 = head;
        ListNode p2 = head.next;

        while(p1!=null&&p1.next!=null&&p2!=null&&p2.next!=null){
            if(p2==p1)
                break;
            p1 = p1.next;
            p2 = p2.next;
            if(p2.next!=null)
                p2 = p2.next;
        }
        if(p2==null||p2.next==null)//没有环节点
            return null;

        p2 = p2.next;
        p1 = head;
        while(p2!=p1){
            p2 = p2.next;
            p1 =p1.next;
        }


        return p2;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        //node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node4;

        System.out.println(new Ch142().detectCycle(node1).val);
    }
}
