package com.ibm.mom.reflection;

import java.lang.reflect.Array;

public class ArrayClassDemo {

	public static void main(String[] args) {
		int[] temp = {1, 2, 3};
		Class<?> c = temp.getClass().getComponentType();
		System.out.println("Type: " + c.getName());
		System.out.println("Length: " + Array.getLength(temp));
	}

}
