package com.company.ch08_SegmentTree;

public class Main {
    public static void testSegmentTree(){
        Integer[] nums={-2,0,3,-5,2,-1};
        SegmentTree<Integer> segTree=new SegmentTree<>(nums, new Merge<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a+b;
            }
        });
        System.out.println(segTree);
    }

    public static void main(String[] args) {
        testSegmentTree();
    }
}
