package com.codergray.lab;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numberOfPairs(new int[]{6,12,3,9,3,5,1}, 12));
    }

    static int numberOfPairs(int[] a, long k) {
        int count = 0;
        int n = a.length;
        Set<Integer> set = new HashSet<>();
        Set<Integer> counted = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(a[i]);
        }

        for(Integer num : set){
            if(set.contains((int)(k-num)) && !counted.contains(num) && !counted.contains((int)(k-num))){
                counted.add(num);
                counted.add((int)(k-num));
                count++;
            }
        }
        return count;
    }

    public int trapRainWater(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int[] maxHeights = new int[heights.length + 1];
        maxHeights[0] = 0;
        for (int i = 0; i < heights.length; i++) {
            maxHeights[i + 1] = Math.max(maxHeights[i], heights[i]);
        }
        int max = 0, area = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            area += Math.min(max, maxHeights[i]) > heights[i] ?
                    Math.min(max, maxHeights[i]) - heights[i] :
                    0;
            max = Math.max(max, heights[i]);
        }
        return area;
    }

    /**
     * @param tagList: The tag list.
     * @param allTags: All the tags.
     * @return: Return the answer
     */
    public int getMinimumStringArray(String[] tagList, String[] allTags) {
        // Write your code here
        Set<String> tags = new HashSet<String>();
        for (String tag : tagList) {
            tags.add(tag);
        }

        int i = 0, j = allTags.length - 1;
        int min = Integer.MAX_VALUE;
        while (i < j) {
            if (tags.contains(allTags[i])) {
                i++;
            }


            if (tags.contains(allTags[j])) {
                j--;
            }

            boolean exists = false;
            for (int k = i; k < j; k++) {
                if (tags.contains(allTags[k])) {
                    exists = true;
                    break;
                }
            }

            if(j - i + 1 < min){
                min = j - i + 1;
            }
        }

        return min;
    }
}
