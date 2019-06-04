package org.swordOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrintListFromTailToHead {
    public class ListNode{
        public Integer val;
        public ListNode next;

        public ListNode(Integer val){
            ListNode.this.val = val;
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode == null){return list;}
        Stack<Integer> stack = new Stack<>();
        while(listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while(stack.size() != 0){
            list.add(stack.pop());
        }
        return list;
    }

    public static void main(String[] args) {
        PrintListFromTailToHead print = new PrintListFromTailToHead();
        ListNode l1 = print.new ListNode(1);
        ListNode l2 = print.new ListNode(2);
        ListNode l3 = print.new ListNode(3);
        ListNode l4 = print.new ListNode(4);
        ListNode l5 = print.new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
        ArrayList<Integer> list = print.printListFromTailToHead(l1);
        for (Integer i:list
             ) {
            System.out.print(i+" ");
        }
    }
}
