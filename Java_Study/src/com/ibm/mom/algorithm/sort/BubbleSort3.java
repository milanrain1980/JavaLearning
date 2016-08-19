package com.ibm.mom.algorithm.sort;

public class BubbleSort3 {

	public static void main(String[] args) {
		int[] a = { 3, 4, 6, 2, 9, 1, 5, 8, 7 };
		// flag indicating if the inner loop has been sorted already, if true ignore the remainning outer loop.
		boolean flag = true;
		for (int i = 0; i < a.length - 1 && flag; i++) {
			flag = false;
			for (int j = a.length - 2; j >= i; j--) {
				if (a[j] > a[j+1]) {
					swap(a, j, j+1);
					flag = true;
				}
			}
		}

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}

	private static int[] swap(int[] a, int i, int j) {
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;

		return a;
	}

}
