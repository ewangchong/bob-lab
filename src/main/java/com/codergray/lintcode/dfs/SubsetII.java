package com.codergray.lintcode.dfs;

import java.util.ArrayList;

/**
 * Created by cwang on 3/6/17.
 */
public class SubsetII {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        helper(result, new ArrayList<Integer>(), nums, 0);

        return result;
    }

    private void helper(ArrayList<ArrayList<Integer>> result,
                        ArrayList<Integer> subset,
                        int[] nums,
                        int startIndex) {
        result.add(new ArrayList<Integer>(subset));
        for (int i = startIndex; i < nums.length; i++) {
            if(i>0 && nums[i]==nums[i-1] && i>startIndex){
                continue;
            }
            subset.add(nums[i]);
            helper(result, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args){
        SubsetII tool = new SubsetII();
        ArrayList<ArrayList<Integer>> result = tool.subsetsWithDup(new int[] {1, 2, 2, 4});
        for (ArrayList<Integer> list :
                result) {
            for (Integer in:
            list){
                System.out.print(in+"->");
            }
            System.out.println();
        }
    }
}
