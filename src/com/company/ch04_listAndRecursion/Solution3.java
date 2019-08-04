package com.company.ch04_listAndRecursion;

public class Solution3 {
    //    public ListNode removeElements(ListNode head, int val) {
//        if(head==null){
//            return null;
//        }
//        ListNode remain=removeElements(head.next,val);
//        if(head.val==val){
//            return remain;
//        }else{
//            head.next=remain;
//            return head;
//        }
//    }
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}