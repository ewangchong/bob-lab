package com.codergray.lintcode.binarysearch;

/**
 * Created by cwang on 3/10/17.
 */
public class ClosestNumber {
    public int closestNumber(int[] A, int target) {
        // Write your code here
        if (null == A || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        int mid = 0;
        while(start+1<end){
            mid = start + (end-start)/2;
            if(A[mid]==target){
                break;
            }
            if(A[mid]>target){
                end = mid;
            }else{
                start = mid;
            }
        }

        return mid;
    }

    public static void main(String[] args){
        ClosestNumber cn = new ClosestNumber();
        System.out.println(cn.closestNumber(new int[]{1,10,15,25,35,45,50,59}, 30));
        System.out.println(cn.closestNumber(new int[]{1,4,6,8}, 3));
        System.out.println(cn.closestNumber(new int[]{1,2,3,4,5,6,7,8,10,100,150,156,179}, 9));
        System.out.println(cn.closestNumber(new int[]{27,32,45,63,74,88,103,114,131,137,148,156,160,166,179,184,200,202,216,228,231,232,246,259,268,275,279,286,291,308,320,333,347,350,367,385,403,408,416,421,427,442,446,464,476,480,497,502,503,515,531,534,543,545,546,558,570,582,599,616,621,637,641,657,661,674,677,689,700,708,724,738,754,760,775,786,794,811,829,830,831,844,862,875,893,906,916,924,931,948,958,964,974,982,983,987,991,994,996,1009,1014,1025,1039,1055,1065,1083,1085,1093,1097,1112,1122,1133,1141,1152,1170,1178,1182,1195,1213,1228,1235,1248,1262,1277,1289,1306,1318,1320,1326,1338,1347}, 636));
    }
}
