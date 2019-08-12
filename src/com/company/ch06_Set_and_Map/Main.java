package com.company.ch06_Set_and_Map;

import com.company.ch03_linkedList.LinkedList;
import com.company.ch11_AVLTree.AVLTree;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.function.DoubleToIntFunction;

public class Main {
    public static void testBSTSet() {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("src/com/company/ch06_Set_and_Map/pride-and-prejudice.txt", words1);
        System.out.println("Total words: " + words1.size());

        BSTSet<String> bstSet1 = new BSTSet<>();
        for (String word : words1) {
            bstSet1.add(word);
        }
        System.out.println("Total different words: " + bstSet1.getSize());
        System.out.println();
        System.out.println("A Tale of Two Cities");
        ArrayList<String> words2 = new ArrayList<>();
        FileOperation.readFile("src/com/company/ch06_Set_and_Map/a-tale-of-two-cities.txt", words2);
        System.out.println("Total words: " + words2.size());

        BSTSet<String> bstSet2 = new BSTSet<>();
        for (String word : words2) {
            bstSet2.add(word);
        }
        System.out.println("Total different words: " + bstSet2.getSize());
    }

    public static void testLinkedListSet() {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("src/com/company/ch06_Set_and_Map/pride-and-prejudice.txt", words1);
        System.out.println("Total words: " + words1.size());

        LinkedListSet<String> linkedListSet1 = new LinkedListSet<>();
        for (String word : words1) {
            linkedListSet1.add(word);
        }
        System.out.println("Total different words: " + linkedListSet1.getSize());
        System.out.println();
        System.out.println("A Tale of Two Cities");
        ArrayList<String> words2 = new ArrayList<>();
        FileOperation.readFile("src/com/company/ch06_Set_and_Map/a-tale-of-two-cities.txt", words2);
        System.out.println("Total words: " + words2.size());

        LinkedListSet<String> linkedListSet2 = new LinkedListSet<>();
        for (String word : words2) {
            linkedListSet2.add(word);
        }
        System.out.println("Total different words: " + linkedListSet2.getSize());
    }

    public static double testSet(Set<String> set,String filename){
        long startTime=System.nanoTime();
        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
//        FileOperation.readFile("src/com/company/ch06_Set_and_Map/pride-and-prejudice.txt", words1);
        FileOperation.readFile(filename,words);
        System.out.println("Total words: " + words.size());

        for (String word : words) {
            set.add(word);
        }
        System.out.println("Total different words: " + set.getSize());

        long endTime= System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }

    public static void testBSTSetAndLinkedSet(){
        String filename="src/com/company/ch06_Set_and_Map/pride-and-prejudice.txt";

        BSTSet<String> bstSet=new BSTSet<>();
        double time1=testSet(bstSet,filename);
        System.out.println("BST Set: "+time1+ " s");

        System.out.println();

        LinkedListSet<String> linkedListSet =new LinkedListSet<>();
        double time2=testSet(linkedListSet,filename);
        System.out.println("Linked List Set: "+ time2+" s");
    }

    public static void testLinkedMap(){
        System.out.println("Pride and Prejudice");

        ArrayList<String> words=new ArrayList<>();
        if(FileOperation.readFile("src/com/company/ch06_Set_and_Map/pride-and-prejudice.txt",words)){
            System.out.println("Total words: "+words.size());

            LinkedListMap<String,Integer> map=new LinkedListMap<>();
            for (String word : words) {
                if(map.contains(word))
                    map.set(word,map.get(word)+1);
                else
                    map.add(word,1);
            }

            System.out.println("Total different words: "+map.getSize());
            System.out.println("Frequency of PRIDE: "+map.get("pride"));
            System.out.println("Frequency of PREJUDICE: "+map.get("prejudice"));
        }
    }

    public static void testBSTMap(){
        System.out.println("Pride and Prejudice");

        ArrayList<String> words=new ArrayList<>();
        if(FileOperation.readFile("src/com/company/ch06_Set_and_Map/pride-and-prejudice.txt",words)){
            System.out.println("Total words: "+words.size());

            BSTMap<String,Integer> map=new BSTMap<>();
            for (String word : words) {
                if(map.contains(word))
                    map.set(word,map.get(word)+1);
                else
                    map.add(word,1);
            }

            System.out.println("Total different words: "+map.getSize());
            System.out.println("Frequency of PRIDE: "+map.get("pride"));
            System.out.println("Frequency of PREJUDICE: "+map.get("prejudice"));
        }
    }

    public static double testAVL(AVLTree<String,Integer> avl,String filename){
        long startTime=System.nanoTime();
        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
//        FileOperation.readFile("src/com/company/ch06_Set_and_Map/pride-and-prejudice.txt", words1);
        FileOperation.readFile(filename,words);
        System.out.println("Total words: " + words.size());

        for (String word : words) {
            if(avl.contains(word))
                avl.set(word,avl.get(word)+1);
            else
                avl.add(word,1);
        }
        System.out.println("Total different words: " + avl.getSize());
        System.out.println("isBST : "+avl.isBST());
        System.out.println("isBalanced : "+avl.isBalanced());
        long endTime= System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }

    public static double testMap(Map<String,Integer> map,String filename){
        long startTime=System.nanoTime();
        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
//        FileOperation.readFile("src/com/company/ch06_Set_and_Map/pride-and-prejudice.txt", words1);
        FileOperation.readFile(filename,words);
        System.out.println("Total words: " + words.size());

        for (String word : words) {
            if(map.contains(word))
                map.set(word,map.get(word)+1);
            else
                map.add(word,1);
        }
        System.out.println("Total different words: " + map.getSize());

        long endTime= System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }

    public static void testBSTMapAndLinkedMap(){
        String filename="src/com/company/ch06_Set_and_Map/pride-and-prejudice.txt";

        BSTMap<String,Integer> bstSet=new BSTMap<>();
        double time1=testMap(bstSet,filename);
        System.out.println("BST Map: "+time1+ " s");

        System.out.println();

        LinkedListMap<String,Integer> linkedListSet =new LinkedListMap<>();
        double time2=testMap(linkedListSet,filename);
        System.out.println("Linked List Map: "+ time2+" s");
    }

    public static void main(String[] args) {
//        testBSTSet();
//        testLinkedListSet();
//        testBSTSetAndLinkedSet();
//        testLinkedMap();
//        testBSTMap();
//        testBSTMapAndLinkedMap();
        AVLTree<String,Integer> avl=new AVLTree<String,Integer>();
        testAVL(avl,"pride-and-prejudice.txt");

    }

}
