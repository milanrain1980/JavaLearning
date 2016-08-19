package com.ibm.mom.string;

/**
 * ������(constant pool)ָ�����ڱ����ڱ�ȷ���������������ѱ����.class�ļ��е�һЩ���ݡ�
 * �������˹����ࡢ�������ӿڵ��еĳ�����Ҳ�����ַ���������
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
	 * ���ȣ�����Ҫ֪��Java��ȷ��һ���ַ�������ֻ��һ�������� 
	 * �����е�s0��s1�еġ�kvill�������ַ��������������ڱ����ھͱ�ȷ���ˣ�����s0==s1Ϊtrue��
	 * ����kv���͡�ill��Ҳ�����ַ� ����������һ���ַ����ɶ���ַ����������Ӷ���ʱ�����Լ��϶�Ҳ���ַ���������
	 * ����s2Ҳͬ���ڱ����ھͱ�����Ϊһ���ַ�������������s2Ҳ�ǳ������� ��kvill����һ�����á� 
	 * �������ǵó�s0==s1==s2; 
	 */
	public static void test1() {
		String s0 = "kvill";
		String s1 = "kvill";
		String s2 = "kv" + "ill";

		System.out.println("s0 == s1 " + (s0 == s1));
		System.out.println("s0 == s2 " + (s0 == s2));
	}
	
	
	/**
	 * ��new String() �������ַ������ǳ����������ڱ����ھ�ȷ��������new String() �������ַ��������볣�����У��������Լ��ĵ�ַ�ռ䡣
	 * �����е�s0���ǳ������С�kvill����Ӧ�ã�s1��Ϊ�޷��ڱ�����ȷ��������������ʱ�������¶���kvill�������ã�
	 * s2��Ϊ�к�벿��new String(��ill��)����Ҳ�޷��ڱ�����ȷ��������Ҳ��һ���´�������kvill����Ӧ��;
	 * ��������ЩҲ��֪��Ϊ�εó��˽���ˡ�
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
