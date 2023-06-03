package com.codergray.hackerrank;

import java.util.Scanner;

/**
 * Created by cwang on 3/10/17.
 */
public class Day10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int max = 0;
        int temp = 0;
        while(n>0){
            int rem = n%2;
            if(rem==1){
                temp++;
            }else{
                temp = 0;
            }
            if(temp>max)
                max = temp;
            n=n/2;
        }
        System.out.println(max);
    }
}
