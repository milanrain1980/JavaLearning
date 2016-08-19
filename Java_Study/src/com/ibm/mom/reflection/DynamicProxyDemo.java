package com.ibm.mom.reflection;

public class DynamicProxyDemo {

	public static void main(String[] args) {
		MyInvocationHandler handler = new MyInvocationHandler();
		
		Subject sub = (Subject) handler.bind(new RealSubject());
		
		String info = sub.say("Bill", 34);
		System.out.println(info);
	}

}
