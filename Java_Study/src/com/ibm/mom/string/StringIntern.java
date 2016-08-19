package com.ibm.mom.string;

public class StringIntern {

	public static void main(String[] args) {
		test1();
		test2();
	}
	
	/**
	 * 存在于.class文件中的常量池，在运行期被JVM装载，并且可以扩充,
	 * String的intern()方法就是扩充常量池的一个 方法:
	 * 当一个String实例str调用intern()方法时,Java查找常量池中是否有相同Unicode的字符串常量，
	 * 如果有,则返回其的引用; 如果没有,则在常量池中增加一个Unicode等于str的字符串并返回它的引用；
	 */
	public static void test1() {
		String s0 = "kvill";
		String s1 = new String("kvill");
		String s2 = new String("kvill");
		System.out.println("s0 == s1 " + (s0 == s1));
		System.out.println("s0 == s2 " + (s0 == s2));
		System.out.println("===========================================");
		s1 = s1.intern();
		s2 = s2.intern(); 		// 把常量池中“kvill”的引用赋给s2
		System.out.println("s0 == s1 " + (s0 == s1));
		System.out.println("s0 == s2 " + (s0 == s2));
		System.out.println("===========================================");
	}
	
	
	public static void test2() {
		String s1 = new String("kvill");
		String s2 = s1.intern();
		System.out.println(s1 == s1.intern());
		System.out.println(s1 + " " + s2);
		System.out.println(s2 == s1.intern());
	}

}
