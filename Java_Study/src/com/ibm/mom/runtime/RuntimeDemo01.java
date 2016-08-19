package com.ibm.mom.runtime;

public class RuntimeDemo01 {

	public static void main(String[] args) {
		Runtime run = Runtime.getRuntime();
		
		System.out.println("JVM max memory is :" + run.maxMemory());
		System.out.println("JVM free memory is :" + run.freeMemory());
		
		String str = "Hello World!!! " + "Welcome to IBM ~";
		System.out.println(str);
		
		for (int x = 0; x < 1000; x++) {
			str +=  x;
		}
		System.out.println("After operation, JVM free memory is: " + run.freeMemory());

		run.gc();
		System.out.println("After GC operation, JVM free memory is : " + run.freeMemory());
	}

}
