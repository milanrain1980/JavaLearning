package com.ibm.mom.string;

/**
 * 常量池(constant pool)指的是在编译期被确定，并被保存在已编译的.class文件中的一些数据。
 * 它包括了关于类、方法、接口等中的常量，也包括字符串常量。
 *
 */
public class StringConstant {

	public static void main(String[] args) {
		System.out.println("====================test1=======================");
		test1();
		System.out.println("====================test2=======================");
		test2();
	}
	
	/**
	 * 首先，我们要知道Java会确保一个字符串常量只有一个拷贝。 
	 * 例子中的s0和s1中的”kvill”都是字符串常量，它们在编译期就被确定了，所以s0==s1为true；
	 * 而”kv”和”ill”也都是字符 串常量，当一个字符串由多个字符串常量连接而成时，它自己肯定也是字符串常量，
	 * 所以s2也同样在编译期就被解析为一个字符串常量，所以s2也是常量池中 ”kvill”的一个引用。 
	 * 所以我们得出s0==s1==s2; 
	 */
	public static void test1() {
		String s0 = "kvill";
		String s1 = "kvill";
		String s2 = "kv" + "ill";

		System.out.println("s0 == s1 " + (s0 == s1));
		System.out.println("s0 == s2 " + (s0 == s2));
	}
	
	
	/**
	 * 用new String() 创建的字符串不是常量，不能在编译期就确定，所以new String() 创建的字符串不放入常量池中，它们有自己的地址空间。
	 * 例子中的s0还是常量池中”kvill”的应用，s1因为无法在编译期确定，所以是运行时创建的新对象”kvill”的引用，
	 * s2因为有后半部分new String(“ill”)所以也无法在编译期确定，所以也是一个新创建对象”kvill”的应用;
	 * 明白了这些也就知道为何得出此结果了。
	 */
	public static void test2() {
		String s0 = "kvill";
		String s1 = new String("kvill");
		String s2 = "kv" + new String("ill");
		System.out.println("s0 == s1 " + (s0 == s1));
		System.out.println("s0 == s2 " + (s0 == s2));
		System.out.println("s1 == s2 " + (s1 == s2));
	}
	
}
