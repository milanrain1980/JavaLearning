package com.ibm.mom.algorithm.sort;

public class SelectionSort1 {

	public static void main(String[] args) {
		int[] a = { 3, 4, 6, 2, 9, 1, 5, 8, 7 };
		int i, j, min;
		for (i = 0; i < a.length - 1; i++) {
			min = i;
			for (j = i + 1; j <= a.length - 1; j++) {
				if (a[min] > a[j]) {
					min = j;
				}
			}
			if (i != min) {
				swap(a, i, min);
			}
		}

		for (i = 0; i < a.length; i++) {
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
