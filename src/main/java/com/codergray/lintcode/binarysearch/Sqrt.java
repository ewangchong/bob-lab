package com.codergray.lintcode.binarysearch;

/**
 * Created by cwang on 2/28/17.
 */
public class Sqrt {
    public static int sqrt(int x) {
        // write your code here
        if(x<=0)
            return 0;

        if(x<4){
            return 1;
        }
        // int start=0;
        long root = x/2;
        long end = x;
        while(true){
            if(root*root<=x && (root+1)*(root+1)>x){
                break;
            }else{
                if(root*root>x){
                    end = root;
                    root = end/2;
                }else{
                    root = (root+end)/2;
                }
            }
        }
        return (int)root;
    }

    public static void main(String[] args){
        System.out.println(sqrt(81));
    }
}