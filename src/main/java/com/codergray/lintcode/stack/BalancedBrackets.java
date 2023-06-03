package com.codergray.lintcode.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by cwang on 3/7/17.
 */
public class BalancedBrackets {
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<Character> ();
        if(expression.length()%2==1){
            return false;
        }
        for(char ch : expression.toCharArray()){
            switch (ch) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if (stack.isEmpty() || ch != stack.peek()) {
                        return false;
                    }
                    stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }
}
