package com.codergray.hackerrank;

import java.util.Scanner;

/**
 * Created by cwang on 3/30/17.
 */
public class Day29 {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for(int i=0; i<T; i++){
            int N=scanner.nextInt();
            int K=scanner.nextInt();

            int bitAnd=0;
            int max=0;
            for(int j=1; j<N; j++){
                for(int k=j+1; k<=N; k++){
                    bitAnd = j&k;
                    if(bitAnd > max && bitAnd<K){
                        max = bitAnd;
//                        System.out.println(max+" "+K);
                    }
                }
            }
            System.out.println(max);
        }
    }
}
