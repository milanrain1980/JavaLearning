package com.ibm.mom.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InstanceDemo03 {

	public static void main(String[] args) {
		Class<?> c = null;
		try {
			c = Class.forName("com.ibm.mendocino.reflection.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Person p = null;
		Constructor<?>[] cons = null;
		cons = c.getConstructors();
		try {
			p = (Person) cons[0].newInstance("Li Gang", 34);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(p);
		
	}

}
