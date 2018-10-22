package com.codergray.amazonTest;

import java.util.logging.Logger;

public abstract class Q2 {
	Logger logger = Logger.getLogger(this.getClass().getName());

	public String check(String input) {
		if (null == input || input.length() == 0) {
			logger.severe("Input is empty");
			return "NO";
		}

		String[] numberStrs = input.split(",");
		int length = numberStrs.length;
		int[] numbers = new int[length];
		try {
			for (int i = 0; i < length; i++) {
				// Turn all numbers to positive number
				numbers[i] = Math.abs(Integer.valueOf(numberStrs[i]));
			}
		} catch (NumberFormatException exception) {
			logger.severe("Invalid format");
			return "NO";
		}

		if (length <= 1) {
			logger.severe("There must be more than 2 numbers.");
			return "NO";
		}
		if (length == 2) {
			if (numbers[0] == numbers[1]) {
				return "YES";
			} else {
				return "NO";
			}
		}

		boolean result = this.isEuqationExists(length, numbers);
		if (result)
			return "YES";
		else {
			return "NO";
		}
	}

	protected abstract boolean isEuqationExists(int len, int[] v);
}
