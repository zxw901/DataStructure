package com.company.ch03_linkedList;

public class Main {
    public static void testLinkedList(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
            if(i%3==2){
                linkedList.removeLast();
                System.out.println(linkedList);
            }
        }
        linkedList.add(2,555);
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println(linkedList);
    }

    public static void main(String[] args) {
        testLinkedList();
    }
}
