package com.huihui.util;

/**
 * Created by hadoop on 2015/6/2 0002.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
    public static void printLinkedList(ListNode head){
        while(head!=null){
            System.out.print(head.val+ ">");
            head = head.next;
        }
    }
}
