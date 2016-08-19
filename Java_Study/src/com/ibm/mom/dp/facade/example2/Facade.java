package com.ibm.mom.dp.facade.example2;

public class Facade {
	private ModuleA a = new ModuleA();
	private ModuleB b = new ModuleB();
	private ModuleC c = new ModuleC();
	
	/**
	 * 下面这些是A、B、C模块对子系统外部提供的方法
	 */
	public void test() {
		a.testA1();
		b.testB1();
		c.testC1();
	}
	
}
