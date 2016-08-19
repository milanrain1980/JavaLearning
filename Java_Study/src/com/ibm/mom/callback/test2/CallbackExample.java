package com.ibm.mom.callback.test2;

public class CallbackExample {

	public static void main(String[] args) {
		FooBar fooBar = new FooBar();
		fooBar.setCallback(new ICallback() {
			public void postExec() {
				System.out.println("在CallbackExample类中实现,但不能被CallbackExample的对象调用,而由FooBar对象调用.");
			}
		});
	}

}
