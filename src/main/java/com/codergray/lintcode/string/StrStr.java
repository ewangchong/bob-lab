package com.codergray.lintcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cwang on 2/22/17.
 */
public class StrStr {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     *
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public static int strStr(String source, String target) {
        if (null == source || target == null) {
            return -1;
        }
        if (target.equals("")) {
            return 0;
        }
        List<Character> resultList = new ArrayList<Character>();
        for (int i = 0; i < source.length(); i++) {
            char srcChar = source.charAt(i);
            char targetChar = target.charAt(resultList.size());
            int j = i;
            while (srcChar == targetChar) {
                resultList.add(srcChar);
                if (resultList.size() == target.length())
                    return i;
                j++;
                if (j == source.length())
                    return -1;
                srcChar = source.charAt(j);
                targetChar = target.charAt(resultList.size());
            }
            resultList.clear();
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("source", "rced"));
    }
}