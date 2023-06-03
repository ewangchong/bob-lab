package com.codergray.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by cwang on 3/6/17.
 */
public class Day6 {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        List<String> results = new ArrayList<String>();
        while(T>0){
            T--;
            String s = scanner.next();
            StringBuilder oddString = new StringBuilder();
            StringBuilder evenString = new StringBuilder();
            for(int i=0; i<s.length(); i++){
                if(i%2==0){
                    evenString.append(s.charAt(i));
                }else{
                    oddString.append(s.charAt(i));
                }
            }
            results.add(evenString.toString() + " " + oddString.toString());
        }

        for(String result : results){
            System.out.println(result);
        }
    }
}
