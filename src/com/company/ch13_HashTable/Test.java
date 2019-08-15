package com.company.ch13_HashTable;

import java.util.Arrays;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

        int[][] arr=new int[10][10];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i],10);
        }

//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }

//        for (int[] ints : arr) {
//            for (int i : ints) {
//                System.out.print(i);
//            }
//        }
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                System.out.println(i);
//            }
//        }


        System.out.println(Integer.toBinaryString(-21));
        System.out.println(Integer.toBinaryString(-21>>31));
        System.out.println(Integer.toBinaryString(-21>>>1));
        int a=-21;
        System.out.println(a>>>1);

        String s="123" ;
        int b=Integer.parseInt(s);
        int c=10;
        System.out.println("b: "+b+" "+"a: "+a);

    }
}
