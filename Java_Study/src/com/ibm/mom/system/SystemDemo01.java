package com.ibm.mom.system;

public class SystemDemo01 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int sum = 0;
		
		for (int i = 0; i < 500000; i++) {
			sum += i;
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("The total number is : " + sum);
		System.out.println("The cost time is : " + (endTime - startTime));
	}

}
