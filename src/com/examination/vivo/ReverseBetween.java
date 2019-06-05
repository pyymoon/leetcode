package com.examination.vivo;
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
    }
}
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n){
        if(head == null | m > n){
            return null;
        }
        if(m == n){
            return head;
        }
        int step = n - m;
        //反转完成的头节点
        ListNode nNode = null;
        //头节点的下一节点
        ListNode nNodeNext = null;
        ListNode mPrev = head;
        ListNode curr = head;
        for (int i = 1; i < m; i++) {
            if(curr.next.next != null){
                mPrev = curr;
                curr = curr.next;
            }
            else{
                return head;
            }
        }
        //反转完成后的尾节点
        ListNode mNode = curr;
        //反转完成后指向反转链表头节点的节点
        ListNode prev = mPrev;
        for (int i = 0; i <= step; i++) {
            if(curr == null){
                break;
            }
            ListNode next = curr.next;
            curr.next = prev;
            nNode = curr;
            prev = curr;
            curr = next;
            nNodeNext = curr;
        }

        mPrev.next = nNode;
        mNode.next = nNodeNext;
        //m=1时此时的头节点为nNode
        if(mPrev == mNode){
            return nNode;
        }
        return head;
    }

}
