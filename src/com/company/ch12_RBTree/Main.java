package com.company.ch12_RBTree;

import com.company.ch05_BST.BST;
import com.company.ch06_Set_and_Map.BSTMap;
import com.company.ch06_Set_and_Map.FileOperation;
import com.company.ch11_AVLTree.AVLTree;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt", words);
        System.out.println("Total words: " + words.size());

        long startTime = System.nanoTime();
        BSTMap<String, Integer> bstMap = new BSTMap<>();
        for (String word : words) {
            if (bstMap.contains(word))
                bstMap.set(word, bstMap.get(word) + 1);
            else
                bstMap.add(word, 1);
        }

        for (String word : words) {
            bstMap.contains(word);
        }

        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("BST:"+bstMap.getSize());
        System.out.println("BST: " + time + " s");

        startTime = System.nanoTime();
        AVLTree<String, Integer> avl = new AVLTree<>();
        for (String word : words) {
            if (avl.contains(word))
                avl.set(word, avl.get(word) + 1);
            else
                avl.add(word, 1);
        }

        for (String word : words) {
            avl.contains(word);
        }

        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL: "+avl.getSize());
        System.out.println("AVL: " + time + " s");

        startTime = System.nanoTime();
        RBTree<String, Integer> rbTree = new RBTree<>();
        for (String word : words) {
            if (rbTree.contains(word))
                rbTree.set(word, rbTree.get(word) + 1);
            else
                rbTree.add(word, 1);
        }

        for (String word : words) {
            rbTree.contains(word);
        }

        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("RBTree: "+rbTree.getSize());
        System.out.println("RBTree: " + time + " s");
    }
}
