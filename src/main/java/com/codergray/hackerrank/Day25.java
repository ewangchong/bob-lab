package com.codergray.hackerrank;

import java.util.Scanner;

/**
 * Created by cwang on 3/28/17.
 */
public class Day25 {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0; i<n; i++){
            int next = scanner.nextInt();
            if(isPrime(next)){
                System.out.println("Prime");
            }else{
                System.out.println("Not prime");
            }
        }
    }

    private static boolean isPrime(int integer){

        if(integer==2){
            return true;
        }
        if(integer<=1 || integer%2==0){
            return false;
        }

        for(int i=3; i<=Math.sqrt(integer); i++){
            if(integer%i==0){
                return false;
            }
        }

        return true;
    }
}
