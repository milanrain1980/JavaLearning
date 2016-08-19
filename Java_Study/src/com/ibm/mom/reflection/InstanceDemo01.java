package com.ibm.mom.reflection;

public class InstanceDemo01 {

	public static void main(String[] args) {
		Class<?> c = null;
		try {
			c = Class.forName("com.ibm.mendocino.reflection.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Person p = null;
		try {
			p = (Person) c.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		p.setAge(33);
		p.setName("Bill");
		
		System.out.println(p);
	}

}
