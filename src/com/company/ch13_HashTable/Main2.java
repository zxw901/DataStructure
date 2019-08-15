package com.company.ch13_HashTable;

import com.company.ch06_Set_and_Map.BSTMap;
import com.company.ch06_Set_and_Map.FileOperation;
import com.company.ch11_AVLTree.AVLTree;
import com.company.ch12_RBTree.RBTree;

import java.util.ArrayList;

public class Main2 {

    public static void main(String[] args) {

        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt", words);
        System.out.println("Total words: " + words.size());

        long startTime=System.nanoTime();
        BSTMap<String,Integer> bst=new BSTMap<>();
        for (String word : words) {
            if(bst.contains(word))
                bst.add(word,bst.get(word)+1);
            else
                bst.add(word,1);
        }
        for (String word : words) {
            bst.contains(word);
        }
        long endTime=System.nanoTime();
        double time=(endTime-startTime)/1000000000.0;
        System.out.println("BST: "+time+" s");

         startTime=System.nanoTime();
        AVLTree<String,Integer> avl=new AVLTree<>();
        for (String word : words) {
            if(avl.contains(word))
                avl.add(word,avl.get(word)+1);
            else
                avl.add(word,1);
        }
        for (String word : words) {
            avl.contains(word);
        }
         endTime=System.nanoTime();
        time=(endTime-startTime)/1000000000.0;
        System.out.println("AVL: "+time+" s");

        startTime=System.nanoTime();
        RBTree<String,Integer> rbTree=new RBTree<>();
        for (String word : words) {
            if(rbTree.contains(word))
                rbTree.add(word,rbTree.get(word)+1);
            else
                rbTree.add(word,1);
        }
        for (String word : words) {
            rbTree.contains(word);
        }
        endTime=System.nanoTime();
        time=(endTime-startTime)/1000000000.0;
        System.out.println("RBTree: "+time+" s");

        startTime=System.nanoTime();
        HashTable<String,Integer> hashtable=new HashTable<>();
        for (String word : words) {
            if(hashtable.contains(word))
                hashtable.add(word,hashtable.get(word)+1);
            else
                hashtable.add(word,1);
        }
        for (String word : words) {
            hashtable.contains(word);
        }
        endTime=System.nanoTime();
        time=(endTime-startTime)/1000000000.0;
        System.out.println("HashTable: "+time+" s");
    }
}
