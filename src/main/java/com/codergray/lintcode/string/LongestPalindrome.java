package com.codergray.lintcode.string;

/**
 * Created by cwang on 2/23/17.
 */
public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        // Write your code here
        int[] count = new int[46];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }

        int result = 0;
        boolean isOddExist = false;
        for (int i = 0; i < 46; i++) {
            if(count[i]%2==0){
                result+=count[i];
            }else{
                result+=(count[i]-1);
                isOddExist = true;
            }
        }

        return result + (isOddExist?1:0);
    }

    public static void main(String[] args){
        System.out.println(longestPalindrome("abccccdd"));
    }
}
