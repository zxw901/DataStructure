package com.company.ch08_SegmentTree;

public class Solution303 {
    public int[] sums;      // sum[i]存储nums[0...i-1]的和
    public Solution303(int[] nums) {
        sums=new int[nums.length+1];
        sums[0]=0;
        for (int i = 1; i < sums.length; i++) {
            sums[i]=nums[i-1]+sums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j+1]-sums[i];
    }
}
