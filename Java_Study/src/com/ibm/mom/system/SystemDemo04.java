package com.ibm.mom.system;

class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("The object is released --> " + this);
	}
}

public class SystemDemo04 {
	public static void main(String[] args) {
		Person p1 = new Person("Zhangsan", 30);
		Person p2 = new Person("Lisi", 40);		
		p1 = null;
		p2 = null;
		System.gc();
	}

}
