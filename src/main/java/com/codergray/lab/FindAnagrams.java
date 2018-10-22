package com.codergray.lab;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    /**
     * @param s: a string
     * @param p: a string
     * @return: a list of index
     */
    public List<Integer> findAnagrams(String s, String p) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();

        int sLen = s.length();
        int pLen = p.length();

        int[] hashA = new int[26];
        int[] hashB = new int[26];
        for(Character ch : p.toCharArray()){
            hashA[ch - 'a']++;
        }

        int start = 0, end = 0;
        while(end < sLen){
            hashB[s.charAt(end) - 'a']++;
            end++;
            if(end - start == pLen) {
                if (arrayEquals(hashA, hashB)) {
                    result.add(start);
                }
                hashB[s.charAt(start) - 'a']--;
                start++;
            }
        }

        return result;
    }
    
    private boolean arrayEquals(int[] A, int[] B){
        if(A.length != B.length){
            return false;
        }
        for(int i=0; i < A.length; i++){
            if(A[i] != B[i]){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args){
        FindAnagrams fa = new FindAnagrams();
        System.out.println(fa.findAnagrams("abcbcabcdbca", "bca"));
    }
}