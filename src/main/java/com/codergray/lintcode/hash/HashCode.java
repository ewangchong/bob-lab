package com.codergray.lintcode.hash;

/**
 * Created by cwang on 4/21/17.
 */
public class HashCode {
    public static int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        long sum = 0;
        for(int i=0; i < key.length; i++){
            sum = sum*33 + key[i];
        }

        return (int)(sum%HASH_SIZE);
    }

    public static void main(String[] args){
        String test = "abcd";
        System.out.println(hashCode(test.toCharArray(), 100));
    }
}
