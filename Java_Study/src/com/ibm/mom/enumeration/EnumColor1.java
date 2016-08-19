package com.ibm.mom.enumeration;

/**
 * 对于枚举类型而言，所有的成员都是enum中的实例，不能从enum之外进行实例化，
 * 因此enum中的方法都隶属于各个具体的实例，而非class中的method。
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
		System.out.println("无参构造器！");
	}
	
	private String color;

	private EnumColor1(String color) {
		this.color = color;
		System.out.println("有参构造器！");
	}
	
	public abstract String toString();
	
}
