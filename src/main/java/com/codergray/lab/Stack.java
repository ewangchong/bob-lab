package com.codergray.lab;

import java.util.LinkedList;
import java.util.Queue;

public class Stack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public Stack(){
        this.queue1 = new LinkedList<Integer>();
        this.queue2 = new LinkedList<Integer>();
    }
    /*
     * @param x: An integer
     * @return: nothing
     */
    public void push(int x) {
        // write your code here
        queue1.offer(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        // write your code here
        moveItems();
        queue1.poll();
        swapQueues();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        moveItems();
        int top = queue1.poll();
        swapQueues();
        queue1.offer(top);
        return top;
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        // write your code here
        return queue1.size() == 0;
    }

    private void moveItems(){
        while(queue1.size()!=1){
            queue2.offer(queue1.poll());
        }
    }

    private void swapQueues(){
        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }
}
