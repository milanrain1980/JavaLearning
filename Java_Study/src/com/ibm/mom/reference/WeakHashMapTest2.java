package com.ibm.mom.reference;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class WeakHashMapTest2 {
	public static void main(String[] args) throws Exception {
		List<WeakHashMap<byte[][], byte[][]>> lists = new ArrayList<WeakHashMap<byte[][], byte[][]>>();
		for (int i = 0; i < 1000; i++) {
			WeakHashMap<byte[][], byte[][]> d = new WeakHashMap<byte[][], byte[][]>();
			d.put(new byte[1000][1000], new byte[1000][1000]);
			lists.add(d);
			System.gc();
			System.err.println(i);
			for (int j = 0; j <= i; j++) {
				System.err.println(j + " size-->" + lists.get(j).size());
			}
		}
	}
}
