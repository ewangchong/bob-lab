package com.codergray.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _9PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        return x == reverse(x);
    }

    private static int reverse(int x){
        int result = 0;
        while(x!=0){
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1000000001));
    }
}
