package com.ibm.mom.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * You have got a range of numbers between 1 to N, where one of the number is repeated. You need to write a program to find out the duplicate number.
 *  - See more at: http://www.java2novice.com/java-interview-programs/duplicate-number/#sthash.9mP6SnkY.dpuf
 */
public class DuplicateNumber {
	public int findDuplicateNumber(List<Integer> numbers) {
		int size = numbers.size();
		int total = getSum(numbers);
		int duplicate = total - (size * (size - 1) / 2);			// µÈ²îÊıÁĞ£º 1+2+...+size-1
		return duplicate;
	}

	public int getSum(List<Integer> numbers) {
		int sum = 0;
		for (int num : numbers) {
			sum += num;
		}
		return sum;
	}

	public static void main(String a[]) {
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 1; i < 30; i++) {
			numbers.add(i);
		}
		// add duplicate number into the list
		numbers.add(22);
		DuplicateNumber dn = new DuplicateNumber();
		System.out.println("Duplicate Number: " + dn.findDuplicateNumber(numbers));
	}
}
