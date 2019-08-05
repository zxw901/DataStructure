package com.company.ch05_BST;

import java.util.ArrayList;
import java.util.Random;

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

    public static void testRemoveMin(){
        BST<Integer> bst=new BST<>();
        Random random = new Random();
        int n=1000;
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> nums=new ArrayList<>();
        while(!bst.isEmpty()){
            nums.add(bst.removeMin());
        }

        System.out.println(nums);
        for (int i = 1; i < nums.size(); i++) {
            if(nums.get(i)<nums.get(i-1))
                throw new IllegalArgumentException("Error");
        }
        System.out.println("removeMin test completed");
    }

    public static void testRemove(){
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        bst.preOrder();
        System.out.println();
        bst.remove(3);
        bst.preOrder();
    }

    public static void main(String[] args) {
//        testtoString();
//        testpreOrderNR();
//        testRemoveMin();
        testRemove();
    }
}
