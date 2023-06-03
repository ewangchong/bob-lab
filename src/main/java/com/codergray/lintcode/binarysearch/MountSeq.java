package com.codergray.lintcode.binarysearch;

/**
 * Created by cwang on 3/10/17.
 */
public class MountSeq {
    public int mountainSequence(int[] nums) {
        // Write your code here
        if(nums==null || nums.length==0){
            return -1;
        }

        int start = 0;
        int end = nums.length-1;

        while(start+1<end){
            int mid = start + (end - start)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return nums[mid];
            }
            if(nums[start] < nums[mid]){
                if(nums[mid] < nums[mid+1]) {
                    start = mid;
                }else{
                    end = mid;
                }
            }else{
                if(nums[mid] < nums[mid+1]) {
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }

        return nums[start]>nums[end]?nums[start]:nums[end];
    }

    public int findFirstBadVersion(int n) {
        // write your code here
        int start = 0;
        int end = n;

        while(start+1<end){
            int mid = start + (end-start)/2;
            if(isBadVersion(mid) && !isBadVersion(mid-1)){
                return mid;
            }

            if(!isBadVersion(start) && !isBadVersion(mid)){
                start = mid;
            }else{
                end = mid;
            }
        }

        return isBadVersion(start)?start:end;
    }

    private boolean isBadVersion(int mid) {
        return true;
    }

    public static void main(String[] args){
        MountSeq ms = new MountSeq();
        int index = ms.mountainSequence(new int[]{1, 3, 4, 5, 6, 8, 19, 23, 33, 25, 19, 11, 8, 1});
        System.out.println(index);
    }
}
