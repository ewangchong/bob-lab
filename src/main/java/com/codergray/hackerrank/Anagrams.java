package com.codergray.hackerrank;

import java.util.Scanner;
/**
 * Created by cwang on 3/3/17.
 */
public class Anagrams {

    public static int numberNeeded(String first, String second) {
        int[] count = new int[26];
        for(int i=0; i<first.length(); i++){
            count[first.charAt(i)-'a']++;
        }
        for(int i=0; i<second.length(); i++){
            count[second.charAt(i)-'a']--;
        }
        int sum = 0;
        for(int i=0; i<26; i++){
            int abs = Math.abs(count[i]);
            sum+=abs;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }

}
