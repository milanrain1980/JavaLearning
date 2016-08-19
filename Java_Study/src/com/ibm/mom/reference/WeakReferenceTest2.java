package com.ibm.mom.reference;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class WeakReferenceTest2 {
	public static void main(String[] args) {
		WeakHashMap<Integer, WeakReference<People>> map = new WeakHashMap<Integer, WeakReference<People>>();
		People p1 = new People("Robin", 1, 28);
		People p2 = new People("Billy", 2, 29);
		People p3 = new People("Harry", 3, 30);
		map.put(new Integer(100), new WeakReference<People>(p1));
		map.put(new Integer(101), new WeakReference<People>(p2));
		map.put(new Integer(1), new WeakReference<People>(p3));

		for (WeakReference<People> wr : map.values()) {
			People p = wr.get();
			System.out.println("people--->" + p);
		}
	}
}

class People {
	private String name;
	private int id;
	private int age;

	public People(String name, int id) {
		this(name, id, 0);
	}

	public People(String name, int id, int age) {
		this.name = name;
		this.id = id;
		this.age = age;
	}

	public String toString() {
		return "id: " + id + " name: " + name + " age: " + age;
	}

	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (!(o instanceof People))
			return false;
		People p = (People) o;
		boolean res = name.equals(p.name);
		if (res)
			System.out.println("name " + name + " is double");
		else
			System.out.println(name + " vS " + p.name);
		return res;
	}

	public int hashCode() {
		return name.hashCode();
	}
}