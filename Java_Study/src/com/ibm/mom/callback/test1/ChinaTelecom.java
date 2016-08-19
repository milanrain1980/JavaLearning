package com.ibm.mom.callback.test1;

public class ChinaTelecom {
	private ServiceProvider sp;

	public void setSp(ServiceProvider sp) {
		this.sp = sp;
	}

	public void init() {
		System.out.println("Welcome, This is ChinaTelecom! ");
		sp.customHint();// sp自定义的操作
	}

}
