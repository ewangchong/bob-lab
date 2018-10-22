package com.codergray.lintcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cwang on 2/23/17.
 */
public class Compare {

    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        if (A == null || B == null)
            return false;

        if (A.length() < B.length())
            return false;

        if (A.equals(B))
            return true;


        int len = A.length();
        Map<Character, Integer> aCharacterIntegerMap = new HashMap<Character, Integer>();
        Map<Character, Integer> bCharacterIntegerMap = new HashMap<Character, Integer>();
        for (int i = 0; i < A.length(); i++) {
            char aChar = A.charAt(i);
            if (aCharacterIntegerMap.get(aChar) == null) {
                aCharacterIntegerMap.put(aChar, 1);
            } else {
                aCharacterIntegerMap.put(aChar, aCharacterIntegerMap.get(aChar) + 1);
            }
        }

        for (int i = 0; i < B.length(); i++) {
            char bChar = B.charAt(i);
            if (bCharacterIntegerMap.get(bChar) == null) {
                bCharacterIntegerMap.put(bChar, 1);
            } else {
                bCharacterIntegerMap.put(bChar, bCharacterIntegerMap.get(bChar) + 1);
            }
        }

        for (Character ch : bCharacterIntegerMap.keySet()) {
            if (aCharacterIntegerMap.get(ch) == null)
                return false;

            int a = aCharacterIntegerMap.get(ch);
            int b = bCharacterIntegerMap.get(ch);
            if (a < b)
                return false;

        }
        return true;
    }
}
