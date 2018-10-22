package com.codergray.lintcode.binarysearch;

/**
 * Created by cwang on 3/11/17.
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
        int result = search.search(new int[]{0, 1, 2, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1}, -9);
        System.out.println(result);
    }

    /*
    0, 1, 2, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1
    -5, -4, -3, -2, -1, 0, 1, 2, -10, -9, -8, -7, -6
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            System.out.println(A[start] + "|" + A[mid] + "|" + A[end]);
            if (A[mid] == target) {
                return mid;
            }

            if (A[mid] > A[start]) {
                if (A[start]<=target && A[mid]>target) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (A[mid] < target && A[end]>target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if (A[start] == target) {
            return start;
        }

        if (A[end] == target) {
            return end;
        }

        return -1;
    }
}
