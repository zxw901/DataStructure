package com.company.ch04_listAndRecursion;
/*
使用虚拟头节点的方法
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead =new ListNode(-1);
        dummyHead.next=head;
        ListNode pre=dummyHead;
        while(pre.next!=null)
        {
            if(pre.next.val==val){
                pre.next=pre.next.next;
            }else{
                pre=pre.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums={1,2,6,3,4,5,6};
        ListNode head=new ListNode(nums);
        System.out.println(head);

        ListNode res=(new Solution2().removeElements(head,6));
        System.out.println(res);
    }
}