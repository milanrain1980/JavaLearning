package com.ibm.mom.internationalization;

public class I18NDemo4 {

	public static void main(String[] args) {
		func("IBM", "HP", "Lenovo");
		func("IBM");
		
		Object[] objects = {"Baidu", "Alibaba", "Tencent"};
		func(objects);
	}

	private static void func(Object... args) {
		for (int i = 0; i < args.length; i++) {
			System.out.print(args[i] + "\t");
		}
		
		System.out.println();
	}
}
