package com.ibm.mom.algorithm.sort;

public class QuickSort {
	public static void main(String[] args) {
		int[] a = { 8, 2, 6, 12, 1, 9, 5, 5, 10 };
		quickSort(a, 0, 8);
	}

	private static void quickSort(int a[], int left, int right) {
		int i = left;
		int j = right;
		int temp = a[left];
		if (left >= right) {
			return;
		}
		while (i != j) {
			while (i < j && a[j] >= temp) {
				j--;
			}
			if (j > i)
				a[i] = a[j];// a[i]已经赋值给temp,所以直接将a[j]赋值给a[i],赋值完之后a[j],有空位

			while (i < j && a[i] <= temp) {
				i++;
			}
			if (i < j)
				a[j] = a[i];
		}
		a[i] = temp;							// 把基准插入,此时i与j已经相等R[low..pivotpos-1].keys≤R[pivotpos].key≤R[pivotpos+1..high].keys
		quickSort(a, left, i - 1);					/* 递归左边 */
		quickSort(a, i + 1, right);				/* 递归右边 */
	}
	
}
