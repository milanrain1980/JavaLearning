package com.ibm.mom.util;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<String>();
		ts.add("red");
		ts.add("green");
		ts.add("yellow");
		ts.add("red");
		System.out.println("size:" + ts.size());
		Iterator<String> it = ts.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("first:" + ts.first());
		System.out.println("last:" + ts.last());

		System.out.println("subset:" + ts.subSet("green", "yellow"));
		// System.out.println("subset2:"+ts.subSet("red","green"));
		ts.remove("green");
		System.out.println("removed size:" + ts.size());

		ts.clear();
		System.out.println("cleared size:" + ts.size());
	}

}
