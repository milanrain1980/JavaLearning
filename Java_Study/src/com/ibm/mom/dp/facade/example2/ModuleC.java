package com.ibm.mom.dp.facade.example2;

public class ModuleC {

	/**
	 * 提供给子系统外部使用的方法
	 */
	public void testC1() {
		System.out.println("Invoke ModuleC - testC1...");
	}

	/**
	 * 子系统内部模块之间相互调用时使用的方法
	 */
	public void testC2() {
		System.out.println("Not visible from outside interface... C2");
	}

	public void testC3() {
		System.out.println("Not visible from outside interface... C3");
	}
}
