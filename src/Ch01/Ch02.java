package Ch01;

/**
 * Created by hadoop on 2015/5/26 0026.
 */
public class Ch02 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 需要注意几个空指针检查就好了。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = null;
        int sum = (l1==null?0:l1.val) + (l2==null?0:l2.val);
        int carry = sum >= 10 ? 1 : 0;//进位
        ListNode root = new ListNode(sum % 10);
        ListNode pre = root;
        l1 = l1==null?null:l1.next;
        l2 = l2==null?null:l2.next;
        for (; l1 != null || l2 != null||carry!=0; l1 = l1==null?null:l1.next, l2 = l2==null?null:l2.next) {
            sum = (l1==null?0:l1.val) + (l2==null?0:l2.val)+carry;
            carry = sum >= 10 ? 1 : 0;
            node = new ListNode(sum%10);
            pre.next = node;
            pre = node;
        }
        return root;
    }
}
