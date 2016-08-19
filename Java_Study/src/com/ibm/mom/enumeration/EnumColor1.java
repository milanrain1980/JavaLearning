package com.ibm.mom.enumeration;

/**
 * ����ö�����Ͷ��ԣ����еĳ�Ա����enum�е�ʵ�������ܴ�enum֮�����ʵ������
 * ���enum�еķ����������ڸ��������ʵ��������class�е�method��
 * @author ligang
 *
 */
public enum EnumColor1 {
	RED("red") {
		@Override
		public String toString() {
			return "This is color - red.";
		}
	}, 
	GREEN("green") {
		@Override
		public String toString() {
			return "This is color - green.";
		}
	}, 
	BLUE("blue") {
		@Override
		public String toString() {
			return "This is color - blue.";
		}
	};
	
	private EnumColor1() {
		System.out.println("�޲ι�������");
	}
	
	private String color;

	private EnumColor1(String color) {
		this.color = color;
		System.out.println("�вι�������");
	}
	
	public abstract String toString();
	
}
