package com.codergray.hackerrank;

import java.util.Scanner;

/**
 * Created by cwang on 3/29/17.
 */
public class Day27 {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i=0; i<T; i++){
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int s[] = new int[N];
            int noLate = 0;
            for(int j=0; j<N; j++){
                s[j] = scanner.nextInt();
                if(s[j] <= 0){
                    noLate++;
                }
            }
            if(noLate < K){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
