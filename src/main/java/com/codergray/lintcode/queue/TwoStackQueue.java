package com.codergray.lintcode.queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by cwang on 3/7/17.
 */
public class TwoStackQueue {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.push(value);
        }

        public T peek() {
            if(stackOldestOnTop.isEmpty()) {
                while (!stackNewestOnTop.isEmpty()) {
                    T v = stackNewestOnTop.pop();
                    stackOldestOnTop.push(v);
                }
            }
            return stackOldestOnTop.peek();
        }

        public T dequeue() {
            if(stackOldestOnTop.isEmpty()) {
                while (!stackNewestOnTop.isEmpty()) {
                    T v = stackNewestOnTop.pop();
                    stackOldestOnTop.push(v);
                }
            }
            return stackOldestOnTop.pop();
        }
    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
