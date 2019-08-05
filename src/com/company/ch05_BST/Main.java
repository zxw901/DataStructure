package com.company.ch05_BST;

public class Main {
    public static void testtoString(){
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        bst.preOrder();
        System.out.println();
        System.out.println(bst);
    }

    public static void testpreOrderNR(){
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        bst.preOrder();
        System.out.println();
        bst.preOrderNR();
    }

    public static void main(String[] args) {
//        testtoString();
        testpreOrderNR();
    }
}
