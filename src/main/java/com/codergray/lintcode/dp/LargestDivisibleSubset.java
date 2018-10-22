package com.codergray.lintcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by cwang on 5/5/17.
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Write your code here
        Arrays.sort(nums);

        for(Integer n : nums){
            System.out.print(n+"->");
        }
        System.out.println();
        int[] f = new int[nums.length];
        int[] pre = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
            pre[i] = i;
//            System.out.println(f[i]+" "+pre[i]);
            for (int j = 0; j < i; j++) {
//                System.out.println(i+" "+ j+" ");
                if (nums[i] % nums[j] == 0 && f[i] < f[j] + 1) {
                    f[i] = f[j] + 1;
                    pre[i] = j;
//                    System.out.println(i+" "+ j+" " + f[i]+" "+pre[i]);
                }
            }
        }

        for(Integer fi : f){
            System.out.print(fi+"->");
        }

        System.out.println();

        for(Integer prei : pre){
            System.out.print(prei+"->");
        }
        System.out.println();

        List<Integer> ans = new ArrayList<Integer>();
        if (nums.length == 0) {
            return ans;
        }
        int max = 0;
        int max_i = 0;
        for (int i = 0; i < nums.length; i++) {
            if (f[i] > max) {
                max = f[i];
                max_i = i;
            }
        }
        ans.add(nums[max_i]);
        while (max_i != pre[max_i]) {
            max_i = pre[max_i];
            ans.add(nums[max_i]);
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args){
        LargestDivisibleSubset lds = new LargestDivisibleSubset();
        List<Integer> res = lds.largestDivisibleSubset(new int[]{1, 2, 4, 8, 3, 9, 27, 54, 108, 16, 32, 64});
        for(Integer i : res){
            System.out.print(i+"->");
        }
    }
}
