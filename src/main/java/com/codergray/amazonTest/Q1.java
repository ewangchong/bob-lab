package com.codergray.amazonTest;

import java.util.Stack;
import java.util.logging.Logger;

/**
 * Q1: Count paired parentheses
 * 
 * Give you a String which has numerous parentheses. The syntax is that left
 * parenthesis must accord to right parenthesis; must begin with left
 * parenthesis. Now program a phase of code , traverse the whole string , judge
 * if the parentheses are a pair and calculate how many pairs in the giving
 * string ; Justify if the string are valid syntax .
 * 
 * Sample Test Case 01:
 * 
 * Input: x= fes(int) (print xxxxx)
 * 
 * Output: 2
 * 
 * Explanation: the number of () is 2, the whole string are valid syntax
 * 
 * Sample Test Case 02:
 * 
 * Input: ()aaa (bbb(sss))ss))
 * 
 * Output: 3
 * 
 * Explanation: the number of () is 3 , the syntax is invalid, there are two
 * consecutive right(left) parenthesis
 * 
 * @author cwang
 * 
 */
public class Q1 {
	Logger logger = Logger.getLogger("Q1");

	public int countParentheses(String input) {
		if (null == input || input.length() == 0) {
			logger.severe("Invalid Input.");
			return 0;
		}

		Stack<Character> pStack = new Stack<Character>();
		int count = 0;
		int leftCount = 0;
		int rightCount = 0;
		boolean valid = true;
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			switch (ch) {
			case '(':
				pStack.push(ch);
				break;
			case ')':
				if (pStack.empty()) {
					valid = false;
					rightCount++;
				} else {
					pStack.pop();
					count++;
				}
				break;
			default:
				break;
			}
		}

		leftCount = pStack.size();
		if (leftCount > 0)
			valid = false;

		if (valid == false) {
			logger.severe("Invalid input: " + input + " There are " + count
					+ " pairs, " + leftCount + " single left parenthesis, and "
					+ rightCount + " single parenthesis.");
		} else {
			logger.info("The input is valid: " + input + ", there are " + count
					+ " pairs.");
		}
		return count;
	}
}
