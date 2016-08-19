package com.ibm.mom.dp.facade.example2;

public class ModuleB {

	/**
	 * 提供给子系统外部使用的方法
	 */
	public void testB1() {
		System.out.println("Invoke ModuleB - testB1...");
	}

	/**
	 * 子系统内部模块之间相互调用时使用的方法
	 */
	public void testB2() {
		System.out.println("Not visible from outside interface... B2");
	}

	public void testB3() {
		System.out.println("Not visible from outside interface... B3");
	}
}
