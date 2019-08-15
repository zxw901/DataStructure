package com.company.ch13_HashTable;

import com.company.ch02_stack_and_queue.Solution;

import java.text.Format;
import java.util.Scanner;

public class App {
//    public static String Solution(int[] rel,int userTotal,int usr,int n){
//        int[][] friend=new int[userTotal][userTotal];
//        for (int i = 0; i < friend.length; i++) {
//            for (int j = 0; j < friend[0].length; j++) {
//                friend[i][j]=Integer.MAX_VALUE;
//            }
//        }
//        for (int i = 0; i <rel.length ;) {
//            int usr1=rel[i];
//            int usr2=rel[i+1];
//            int tmp=rel[i+2];
//            friend[usr1][usr2]=tmp;
//            friend[usr2][usr1]=tmp;
//            i=i+3;
//        }
//        int v=0, min=Integer.MAX_VALUE,w=0, k=0;
//        int[] D=new int[userTotal]; //最短路径
//        int[] P=new int[userTotal];
//        int[] res=new int[userTotal];
//        for (; v < userTotal; v++) {
//            res[v]=0;
//            D[v]=friend[usr][v];
//            P[v]=0;
//        }
//
//        D[usr]=0;
//        res[usr]=1;
//        for (v = 1; v <userTotal; v++) {
//            min=Integer.MAX_VALUE;
//            for (w=0; w < userTotal; w++) {
//                if((res[w]==0)&&D[w]<min){
//                    k=w;
//                    min=D[w];
//                }
//            }
//            res[k]=1;
//            for (w= 0; w <userTotal ; w++) {
//                if(res[w]==0&&(min+friend[k][w]<D[w])){
//                    D[w]=min+friend[k][w];
//                    P[w]=k;
//                }
//            }
//        }
//    }

    public static void Solution(){
        Scanner scanner=new Scanner(System.in);
        int times=scanner.nextInt();
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < times; i++) {
            int usrTotal=scanner.nextInt();
            int usr=scanner.nextInt();
            int n=scanner.nextInt();
            int k=scanner.nextInt();
            int[] rel=new int[3*k];
            for (int j = 0; j < rel.length; j++) {
                rel[j]=scanner.nextInt();
            }
//            for (int j = 0; j < rel.length; j++) {
//                System.out.print(rel[j]+" ");
//            }
//            System.out.println();
//            sb.append(Solution(rel,usrTotal,usr,n));
            if(i!=times-1)
                sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Solution();
    }
}
