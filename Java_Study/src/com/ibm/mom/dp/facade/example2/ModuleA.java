package com.ibm.mom.dp.facade.example2;

public class ModuleA {

	/**
	 * 提供给子系统外部使用的方法
	 */
	public void testA1() {
		System.out.println("Invoke ModuleA - testA1...");
	}

	/**
	 * 子系统内部模块之间相互调用时使用的方法
	 */
	public void testA2() {
		System.out.println("Not visible from outside interface... A2");
	}

	public void testA3() {
		System.out.println("Not visible from outside interface... A3");
	}
}
