package com.codergray.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ZigzagIterator2 {
    private List<Iterator<Integer>> iterators;
    private int count = 0;
    private int k = 0;
    /*
     * @param vecs: a list of 1d vectors
     */public ZigzagIterator2(List<List<Integer>> vecs) {
        // do intialization if necessary
        iterators = new ArrayList<Iterator<Integer>>();
        for(List<Integer> vec : vecs){
            if(vec.size() > 0){
                iterators.add(vec.iterator());
            }
        }
        k = iterators.size();
    }

    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        int ret = iterators.get(count).next();
        if(iterators.get(count).hasNext()){
            count = (count + 1) % k;
        }else{
            iterators.remove(count);
            k--;
            if(k!=0) {
                count %= k;
            }
        }
        return ret;
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here
        return iterators.size()>0;
    }
    
    public static void main(String[] args){
        List<List<Integer>> vecs = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(11);
        List<Integer> list2 = Arrays.asList(1,2,3,4,112,87);
        List<Integer> list3 = Arrays.asList(564);
        List<Integer> list4 = Arrays.asList(789,12,15);
        vecs.add(list1);
        vecs.add(list2);
        vecs.add(list3);
        vecs.add(list4);
        ZigzagIterator2 zi2 = new ZigzagIterator2(vecs);
        while(zi2.hasNext()){
            System.out.println(zi2.next());
        }
    }
}

/**
 * Your ZigzagIterator2 object will be instantiated and called as such:
 * ZigzagIterator2 solution = new ZigzagIterator2(vecs);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */