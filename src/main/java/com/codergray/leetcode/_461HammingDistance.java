package com.codergray.leetcode;

public class _461HammingDistance {
    public int hammingDistance(int x, int y) {
        int i = 1;
        int distance = 0;
        while (x > i || y > i) {
            if (x % 2 != y % 2) {
                distance++;
            }
            x /= 2;
            y /= 2;
            i *= 2;
        }
        return distance;
    }
    
}
