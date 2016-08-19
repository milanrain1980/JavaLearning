package com.ibm.mom.reference;

import java.lang.ref.WeakReference;

class A {
	public String str;
}

public class WeakReferenceTest {
	public static void main(String[] args) {
		A a = new A();
		a.str = "Hello, reference";
		WeakReference<A> wr = new WeakReference<A>(a);
		a = null;
		int i = 0;
		while (wr.get() != null) {
			System.out.println(String.format("Get str from object of WeakReference: %s, count: %d", wr.get().str, ++i));
			if (i % 10 == 0) {
				System.gc();
				System.out.println("System.gc() was invoked!");
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("object a was cleared by JVM!");
	}

}