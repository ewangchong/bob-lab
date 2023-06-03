package com.codergray.amazonTest;

import java.util.Arrays;

/***
 * Q 2: Check numbers can be made into a expression
 * 
 * Input is a string of numbers separated with comma(,) for example: 7,9,4,2
 * 
 * Use three operators add(+) minus(-) and equal(=) to make a correct
 * expression, for example: 7-2+4=9 or 9-7=4-2 or others.
 * 
 * equal(=) has to be included only once. e.g. input:1,1,1,1 expression:1=1=1=1
 * is not a valid expression, 1+1-1=1 is a valid expression.
 * 
 * If the input string can be made at least one such expression, output: YES,
 * otherwise output: NO
 * 
 * @author cwang
 * 
 */
public class Q2_Quicksort extends Q2 {

	/***
	 * Use quick sort to get the answer
	 * 
	 * @param len
	 * @param half
	 * @param v
	 * @return
	 */
	protected boolean isEuqationExists(int length, int[] numbers) {
		Arrays.sort(numbers);

		int tmp = numbers[length - 1] - numbers[length - 2];
		for (int i = length - 3; i >= 0; i--) {
			if (Math.abs(tmp + numbers[i]) <= Math.abs(tmp - numbers[i])) {
				tmp += numbers[i];
			} else {
				tmp -= numbers[i];
			}
			System.out.println(tmp + " ");
		}

		if (tmp == 0)
			return true;
		else {
			return false;
		}
	}
}
