package com.codergray.lintcode.binarysearch;

/**
 * Created by cwang on 5/31/17.
 */
public class TotalOccur {
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        if(A==null || A.length==0){
            return 0;
        }

        int end = A.length-1;
        int start = 0;

        if(target<A[start] || target>A[end]){
            return 0;
        }

        int count = 0;
        int mid = start + (end-start)/2;
        while(start+1<end){
            if(A[mid]==target){
                count++;
                int i = mid;
                while(i>0 && A[--i]==target){
                    count++;
                }
                i = mid;
                while(i<end && A[++i]==target){
                    count++;
                }
                break;
            }
            if(A[mid]<target){
                start = mid;
                mid = start + (end-start)/2;
            }else{
                end = mid;
                mid = start + (end-start)/2;
            }
        }

        return count;
    }

    public static void main(String[] args){
        TotalOccur to = new TotalOccur();
        System.out.println(to.totalOccurrence(new int[]{100,156,189,298,299,300,1001,1002,1003,1004},1000));
    }
}
