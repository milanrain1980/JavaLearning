package com.ibm.mom.string;

public class StringIntern {

	public static void main(String[] args) {
		test1();
		test2();
	}
	
	/**
	 * ������.class�ļ��еĳ����أ��������ڱ�JVMװ�أ����ҿ�������,
	 * String��intern()�����������䳣���ص�һ�� ����:
	 * ��һ��Stringʵ��str����intern()����ʱ,Java���ҳ��������Ƿ�����ͬUnicode���ַ���������
	 * �����,�򷵻��������; ���û��,���ڳ�����������һ��Unicode����str���ַ����������������ã�
	 */
	public static void test1() {
		String s0 = "kvill";
		String s1 = new String("kvill");
		String s2 = new String("kvill");
		System.out.println("s0 == s1 " + (s0 == s1));
		System.out.println("s0 == s2 " + (s0 == s2));
		System.out.println("===========================================");
		s1 = s1.intern();
		s2 = s2.intern(); 		// �ѳ������С�kvill�������ø���s2
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
