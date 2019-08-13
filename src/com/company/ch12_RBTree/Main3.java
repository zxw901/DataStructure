package com.company.ch12_RBTree;

import com.company.ch06_Set_and_Map.BSTMap;
import com.company.ch11_AVLTree.AVLTree;

import java.util.ArrayList;

public class Main3 {
    public static void main(String[] args) {
        int n = 20000000;

        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            testData.add(i);
        }


        long startTime = System.nanoTime();
        AVLTree<Integer, Integer> avl = new AVLTree<>();
        for (Integer x : testData) {
            avl.add(x, null);
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL: " + time + " s");



        startTime = System.nanoTime();
        RBTree<Integer, Integer> rbTree = new RBTree<>();
        for (Integer x : testData) {
            rbTree.add(x, null);
        }
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("RBTree: " + time + " s");
    }
}
