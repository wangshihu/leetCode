package Ch81_100;

import com.huihui.util.ListNode;

/**
 * Created by hadoop on 2015/6/2 0002.
 */
public class Ch92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m<1)
            m=1;
        int num =1;
        int size = 0;
        ListNode[] stack = new ListNode[n-m+1];
        ListNode result = new ListNode(-1);
        ListNode pre = result;
        while(head!=null){
            if(num>=m&&num<=n){
                stack[size++] = head;
                if(num==n)
                     break;
            }else{
                pre.next = head;
                pre = head;
            }
            head=head.next;
            num++;
        }
        ListNode temp = head==null?null:head.next;
        for(int i=size-1;i>=0;i--){
            pre.next = stack[i];
            pre = pre.next;
        }
        pre.next = temp;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
//        ListNode node2 = new ListNode(3);
//        node1.next = node2;
//        ListNode node3 = new ListNode(4);
//        node2.next = node3;
//        ListNode node4 = new ListNode(5);
//        node3.next = node4;
//        ListNode node5 = new ListNode(6);
//        node4.next = node5;

        head = new Ch92().reverseBetween(head,1,2);
        ListNode.printLinkedList(head);

    }
}
