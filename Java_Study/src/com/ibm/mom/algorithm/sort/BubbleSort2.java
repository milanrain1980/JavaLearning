package com.ibm.mom.algorithm.sort;

public class BubbleSort2 {

	public static void main(String[] args) {
		int[] a = { 3, 4, 6, 2, 9, 1, 5, 8, 7 };
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = a.length - 2; j >= i; j--) {
				if (a[j] > a[j+1]) {
					swap(a, j, j+1);
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
