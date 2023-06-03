package com.codergray.lintcode.binarysearch;

/**
 * Created by cwang on 3/10/17.
 */
public class SearchMatrix {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix==null || matrix.length==0){
            return false;
        }
        int m = matrix.length;
        if(matrix[0]==null || matrix[0].length==0){
            return false;
        }
        int n = matrix[0].length;

        int start = 0;
        int end = m*n-1;
        int mid = 0;

        while(start+1<end){
            mid = start + (end-start)/2;
            int[] midIndex = getMatrix(mid, m, n);
            if(matrix[midIndex[0]][midIndex[1]] == target){
                return true;
            }
            if(matrix[midIndex[0]][midIndex[1]] > target){
                end = mid;
            }else{
                start = mid;
            }
        }

        if(matrix[0][0] == target){
            return true;
        }else if(matrix[m-1][n-1]==target){
            return true;
        }else{
            return false;
        }
    }

    private int[] getMatrix(int seq, int m, int n) {
        int[] result = new int[2];
        result[0] = seq / n;
        result[1] = seq - n * result[0];
        System.out.println(result[0]+" "+result[1]);
        return result;
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,12,16},{17,18,19,20}};
        SearchMatrix sm = new SearchMatrix();
        System.out.println(sm.searchMatrix(matrix, 7));
    }
}
