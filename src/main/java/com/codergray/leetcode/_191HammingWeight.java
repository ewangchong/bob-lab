package com.codergray.leetcode;

public class _191HammingWeight {
    public static int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            n &= n-1;
            count++;
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(hammingWeight(9));
    }
}
