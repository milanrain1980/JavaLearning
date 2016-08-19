package com.ibm.mom.proxy.dynamic_proxy_example2;

public class ConcreteClass implements TargetInterface {

	@Override
	public int targetMethodA(int number) {
		System.out.println("开始调用目标类的方法targetMethodA...");
		System.out.println("操作-打印数字:" + number);
		System.out.println("结束调用目标类的方法targetMethodA...");
		
		return number;
	}

	@Override
	public int targetMethodB(int number) {
		System.out.println("开始调用目标类的方法targetMethodB...");
		System.out.println("操作-打印数字:" + number);
		System.out.println("结束调用目标类的方法targetMethodB...");
		
		return number;
	}

}
