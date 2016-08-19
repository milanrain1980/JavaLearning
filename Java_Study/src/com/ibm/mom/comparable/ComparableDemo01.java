package com.ibm.mom.comparable;

import java.util.Arrays;

public class ComparableDemo01 {

	public static void main(String[] args) {
		Student[] students = {
				new Student("Zhangsan", 20, 90.0f),
				new Student("Lisi", 22, 90.0f),
				new Student("Wangwu", 20, 99.0f),
				new Student("Zhaoliu", 20, 70.0f),
				new Student("Sunqi", 22, 100.0f)
		};
		
		Arrays.sort(students);
		
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i]);
		}
	}

}
