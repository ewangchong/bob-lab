package com.codergray.lintcode.tree;

public class UniqueBinarySearchTrees {

	public static void main(String[] args) {
		for(int i=1; i<10; i++){
			System.out.println(i+":"+numTrees(i));
		}
	}

	public static int numTrees(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		int[] record = new int[n + 1];
		record[0] = 1;
		record[1] = 1;
		record[2] = 2;
		for (int i = 3; i <= n; i++) {
			int tmp = 0;
			for (int k = 0; k < i; k++) {
				tmp += (record[k] * record[i - k - 1]);
			}
			record[i] = tmp;
		}
		return record[n];
	}
}
