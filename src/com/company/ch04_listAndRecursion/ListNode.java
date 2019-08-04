package com.company.ch04_listAndRecursion;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) {
        val = x;
    }

    ListNode(int[] x){
        if(x==null||x.length==0){
            throw new IllegalArgumentException("arr can not be empty");
        }

        this.val=x[0];
        ListNode cur=this;
        for (int i = 1; i < x.length; i++) {
            cur.next=new ListNode(x[i]);
            cur=cur.next;
        }
    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        ListNode cur=this;
        while(cur!=null){
            sb.append(cur.val+"->");
            cur=cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
