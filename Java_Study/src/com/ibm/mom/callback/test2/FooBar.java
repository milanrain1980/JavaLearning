package com.ibm.mom.callback.test2;

public class FooBar {
	private ICallback callback;

	public void setCallback(ICallback callback) {
		this.callback = callback;
		doSth();
	}

	public void doSth() {
		callback.postExec();
	}
}
