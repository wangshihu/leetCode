package Ch21_40;

import com.huihui.util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * Created by hadoop on 2015/5/27 0027.
 */
public class Ch23 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val>o2.val)
                    return 1;
                else if(o1.val==o2.val)
                    return 0;
                else
                    return -1;
            }
        };
        Queue<ListNode> queue = new PriorityQueue<ListNode>(100,comparator);
        for(ListNode node:lists){
            if(node!=null)
                queue.add(node);
        }
        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            pre.next = node;
            pre = pre.next;
            if(node.next!=null){
                queue.add(node.next);
            }
        }
        pre.next = null;

        return head.next;
    }



    public static void main(String[] args) {

//        Ch23 ch = new Ch23();
//        ListNode node1 = new ListNode(1);
//        node1.next = new ListNode(4);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode[] listNodes = new ListNode[3];
//        listNodes[0] = node1;
//        listNodes[1] = node2;
//        listNodes[2] = node3;
        Random random =  new Random();
        ListNode[] listNodes = new ListNode[100];
        for(int i=0;i<listNodes.length;i++){
            if(i%15==0)
                listNodes[i] = null;
            else{
                ListNode node = new ListNode(random.nextInt(100));
                listNodes[i] = node;
                for(int j=0;j<random.nextInt(3);j++){
                    ListNode next = new ListNode(random.nextInt(100));
                    node.next = next;
                    node = node.next;
                }
            }
        }
        ListNode result = new Ch23().mergeKLists(listNodes);
        ListNode.printLinkedList(result);



    }

}
