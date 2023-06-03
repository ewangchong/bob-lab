package com.codergray.lintcode.misc;

public class SingleNumber {

	public static void main(String[] args) {
		System.out.println(SingleNumber.singleNumber(new int[]{1,1,2,2,3,3,4}));
		System.out.println(SingleNumber.singleNumber(new int[]{1}));
		System.out.println(SingleNumber.singleNumber(new int[]{}));
	}
	
    public static int singleNumber(int[] A) {
    	assert(A.length>2);
    	int result = 0;
    	for(int i=0; i<A.length; i++){
    		result=result^A[i];
    	}
    	return result;
    }

}
