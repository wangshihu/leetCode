package Ch01;

/**
 * Created by hadoop on 2015/5/26 0026.
 */
public class Ch19 {
    static  class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //双指针移除单链表末端第N个节点.时间复杂度O(n)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return head;
        }
        ListNode p2Node = head;
        ListNode p1Node = head;
        int i=0;
        for(i=0;i<n;i++){
            if(p2Node.next!=null){
                p2Node = p2Node.next;
            }else{
                break;
            }
        }
        if(p2Node.next==null&&n>i){
            return p1Node.next;
        }
        boolean flag =true;
        while(p2Node.next!=null){
            flag =false;
            p2Node=p2Node.next;
            p1Node=p1Node.next;
        }
        if(p1Node.next==null){
            head = null;
        }else if(p1Node==head&&!flag){
            return p1Node.next;
        }else{
            p1Node.next = p1Node.next.next;
        }
        return head;
    }
    public void print(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode pre = head;
        for(int i=2;i<3;i++){
            ListNode node = new ListNode(i);
            pre.next = node;
            pre = node;
        }
        Ch19 ch = new Ch19();
        ch.print(head);
        head = ch.removeNthFromEnd(head, 2);
        ch.print(head);
    }
}
