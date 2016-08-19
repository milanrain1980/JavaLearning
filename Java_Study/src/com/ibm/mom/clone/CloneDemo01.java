package com.ibm.mom.clone;

public class CloneDemo01 {

	public static void main(String[] args) throws CloneNotSupportedException {
		Person p = new Person("Zhangsan", 30);
		Person p2 = (Person) p.clone();
		p2.setName("Lisi");
		p2.setAge(40);
		
		System.out.println(p);
		System.out.println(p2);
	}

}
