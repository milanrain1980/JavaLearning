package com.ibm.mom.dp.facade.example1;

public class Facade {
	private ModuleA a = new ModuleA();
	private ModuleB b = new ModuleB();
	private ModuleC c = new ModuleC();

	// 示意方法，满足客户端需要的功能
	public void test() {
		a.testA();
		b.testB();
		c.testC();
	}

}
