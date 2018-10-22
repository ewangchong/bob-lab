package com.codergray.lintcode.misc;

public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(-123));
	}

	public static int reverse(int x) {
		int sign = 1;
		if (x < 0) {
			sign = -1;
			x = -x;
		}

		int result = 0;
		while (x > 0) {
			int rem = x % 10;
			result = result * 10 + rem;
			x=x/10;
		}

		return result * sign;

	}
}
