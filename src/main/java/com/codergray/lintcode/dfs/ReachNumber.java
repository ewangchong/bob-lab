package com.codergray.lintcode.dfs;

public class ReachNumber {
    public static void main(String[] args){
        System.out.println(reachNumber(8));
    }
    public static int reachNumber(int target) {
        // Write your code here
        target = Math.abs(target);

        int pos = 0, step = 1;
        while( pos < target){
            pos += step;
            step++;
        }
        step--;

        if(pos == target) return step;

        pos -= target;

        if(pos % 2 ==0){
            return step;
        }else if( (step + 1) % 2 == 1 ){
            return step + 1;
        }else{
            return step + 2;
        }
    }
}