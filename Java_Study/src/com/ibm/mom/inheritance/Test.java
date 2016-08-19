package com.ibm.mom.inheritance;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public void add(List list, String str) {
		list.add(str);
	}

	public static void main(String[] args) {
		Test myClass = new Test();
		List<Integer> list = new ArrayList<Integer>();
		myClass.add(list, "123");
		myClass.add(list, "abc");
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		
		System.out.println(list instanceof List<?>);
	}
}