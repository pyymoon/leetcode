package com.leetcode.medium;

import org.omg.PortableInterceptor.INACTIVE;

import com.leetcode.medium.ReverseBetween;

import java.util.Stack;

//class ListNode{
//    int val;
//    ListNode next;
//    public ListNode(int x){
//        val = x;
//    }
//}
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> op1Stack = new Stack<>();
        Stack<Integer> op2Stack = new Stack<>();
        Stack<Integer> resultStack = new Stack<>();
        int add = 0;
        while (l1 != null) {
            op1Stack.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            op2Stack.push(l2.val);
            l2 = l2.next;
        }
        while (!op1Stack.isEmpty() | !op2Stack.isEmpty()) {
            if (op2Stack.isEmpty()) {
                while (!op1Stack.isEmpty()) {
                    int cur = op1Stack.pop();
                    resultStack.push((cur + add) % 10);
                    if (cur + add > 9) {
                        add = 1;
                    } else {
                        add = 0;
                    }
                }
            } else if (op1Stack.isEmpty()) {
                while (!op2Stack.isEmpty()) {
                    int cur = op2Stack.pop();
                    resultStack.push((cur + add) % 10);
                    if (cur + add > 9) {
                        add = 1;
                    } else {
                        add = 0;
                    }
                }
            } else {
                int op1 = op1Stack.pop();
                int op2 = op2Stack.pop();
                int sum = op1 + op2;
                resultStack.push((sum + add) % 10);
                if (sum + add > 9) {
                    add = 1;
                } else {
                    add = 0;
                }

            }
        }
        if (add != 0) {
            resultStack.push(add);
        }
        ListNode head = new ListNode(resultStack.pop());
        ListNode pNode = head;
        while (!resultStack.isEmpty()) {
            ListNode node = new ListNode(resultStack.pop());
            pNode.next = node;
            pNode = node;
        }
        return head;
    }

    public static void main(String[] args) {
        AddTwoNumbers atn = new AddTwoNumbers();
        int[] arr1 = {8, 6};
        int[] arr2 = {6, 4, 8};
        ListNode head1 = new ListNode(arr1[0]);
        ListNode head2 = new ListNode(arr2[0]);
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        if (arr1.length > 1) {
            for (int i = 1; i < arr1.length; i++) {
                ListNode node = new ListNode(arr1[i]);
                cur1.next = node;
                cur1 = node;
            }
        }
        if (arr2.length > 1) {
            for (int i = 1; i < arr2.length; i++) {
                ListNode node = new ListNode(arr2[i]);
                cur2.next = node;
                cur2 = node;
            }
        }
        ListNode resultNode = atn.addTwoNumbers(head1, head2);

    }
}
