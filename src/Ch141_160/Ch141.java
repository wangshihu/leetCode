package Ch141_160;

import com.huihui.util.ListNode;

/**
 * Created by hadoop on 2015/6/8 0008.
 */
public class Ch141 {
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        ListNode p1 = head;
        ListNode p2 = head.next;

        while(p1!=null&&p1.next!=null&&p2!=null&&p2.next!=null){
            if(p2==p1)
                return true;
            p1 = p1.next;
            p2 = p2.next;
            if(p2.next!=null)
                p2 = p2.next;
        }
        return false;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;

        System.out.println(new Ch141().hasCycle(node1));
    }
}
