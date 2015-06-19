package Ch21_40;

/**
 * Created by hadoop on 2015/5/27 0027.
 */
public class Ch21 {
    static  class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        else if(l2==null)
            return l1;

        ListNode head = null;
        if(l1.val<l2.val){
            head = l1;
            head.next = mergeTwoLists(l1.next,l2);
        }else{
            head = l2;
            head.next = mergeTwoLists(l1,l2.next);
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
