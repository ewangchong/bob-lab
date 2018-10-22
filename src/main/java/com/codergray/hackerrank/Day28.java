package com.codergray.hackerrank;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cwang on 3/30/17.
 */
public class Day28 {
    private static String GmailRegEx = "[a-z]+@gmail.com";

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Map<String, String> gmailmap = new HashMap<String, String>();
        for(int i=0; i < N; i++){
            String name = scanner.next();
            String email = scanner.next();

            // Create a Pattern object (compiled RegEx) and save it as 'p'
            Pattern p = Pattern.compile(GmailRegEx);

            // We need a Matcher to match our compiled RegEx to a String
            Matcher m = p.matcher(email);

            // if our Matcher finds a match
            if( m.find() ) {
                gmailmap.put(email, name);
            }
        }

        ArrayList<String> names = new ArrayList<String>();
        for(Map.Entry<String, String> entry: gmailmap.entrySet()){
            names.add(entry.getValue());
        }

        Collections.sort(names);

        for(String name : names){
            System.out.println(name);
        }
    }
}
