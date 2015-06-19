package ch121_140;

import com.huihui.util.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hadoop on 2015/6/8 0008.
 */
public class Ch138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode,RandomListNode> map = new HashMap<>();

        RandomListNode result = new RandomListNode(-1);
        RandomListNode pre =result;
        RandomListNode temp = head;
        while(head!=null){
            RandomListNode node = new RandomListNode(head.label);
            map.put(head,node);
            head = head.next;
            pre.next = node;
            pre = pre.next;
        }
        pre = result.next;
        while(temp!=null){
            pre.random = map.get(temp.random);
            temp = temp.next;
            pre = pre.next;
        }
        return result.next;
    }
}
