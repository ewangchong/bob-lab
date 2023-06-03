package com.codergray.hackerrank;

import java.util.*;

/**
 * Created by cwang on 3/3/17.
 */
public class RansomNote {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        Map<String, Integer> mCount = new HashMap<String, Integer>();
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
            String word = magazine[magazine_i];
            if (null==mCount.get(word)){
                mCount.put(word, 1);
            }else{
                int count = mCount.get(word);
                mCount.replace(word,++count);
            }
        }
        Map<String, Integer> rCount = new HashMap<String, Integer>();
        String ransom[] = new String[n];
        String result = "Yes";
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
            String word = ransom[ransom_i];
            if(null==mCount.get(word)){
                result = "No";
                break;
            }

            int count = mCount.get(word);
            if(count>0){
                mCount.replace(word, count-1);
            }else{
                result = "No";
                break;
            }
        }

        System.out.println(result);
    }
}
