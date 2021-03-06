package com.ibm.mom.reference;

import java.util.WeakHashMap;

class Element {
	private String ident;

	public Element(String id) {
		ident = id;
	}

	public String toString() {
		return ident;
	}

	public int hashCode() {
		return ident.hashCode();
	}

	public boolean equals(Object obj) {
		return obj instanceof Element && ident.equals(((Element) obj).ident);
	}

	protected void finalize() {
		System.out.println("Finalizing " + this.getClass().getSimpleName()	+ " " + ident);
	}
}

class Key extends Element {
	public Key(String id) {
		super(id);
	}
}

class Value extends Element {
	public Value(String id) {
		super(id);
	}
}

public class MapCache {
	public static void main(String[] args) {
		int size = 10000;
		Key[] keys = new Key[size];
		WeakHashMap<Key, Value> map = new WeakHashMap<Key, Value>();

		for (int i = 0; i < size; i++) {
			Key k = new Key(Integer.toString(i));
			Value v = new Value(Integer.toString(i));
			if (i % 3 == 0) {
				keys[i] = k;
			}
			map.put(k, v);
		}
		System.gc();
	}
}
