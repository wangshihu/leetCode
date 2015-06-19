package Ch141_160;

import com.huihui.util.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by hadoop on 2015/6/9 0009.
 */
public class Ch143 {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null)
            return ;
        Deque<ListNode> queue = new LinkedList<>();
        ListNode tempHead = head;
        tempHead = tempHead.next;
        while(tempHead!=null){
            queue.add(tempHead);
            tempHead = tempHead.next;
        }
        tempHead = head;
        boolean last = true;
        while(!queue.isEmpty()){
            tempHead.next = last?queue.pollLast():queue.pollFirst();
            tempHead=tempHead.next;
            last = !last;
        }
        tempHead.next = null;
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
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
        new Ch143().reorderList(node1);
        ListNode.printLinkedList(node1);
    }
}
