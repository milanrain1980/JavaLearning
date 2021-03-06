package com.ibm.mom.reference;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/**
 * WeakHashMap是主要通过expungeStaleEntries这个函数的来实现移除其内部不用的条目从而达到的自动释放内存的目的的
 * .基本上只要对WeakHashMap的内容进行访问就会调用这个函数，从而达到清除其内部不在为外部引用的条目。
 * 但是如果预先生成了WeakHashMap，而在GC以前又不曾访问该WeakHashMap,那不是就不能释放内存了吗？
 * 
 * 由于Java默认内存是64M，所以在不改变内存参数的情况下，该测试跑不了几步循环就内存溢出了。
 * 果不其然，WeakHashMap这个时候并没有自动帮我们释放不用的内存。
 */
public class WeakHashMapTest1 {
	public static void main(String[] args) throws Exception {
		List<WeakHashMap<byte[][], byte[][]>> lists = new ArrayList<WeakHashMap<byte[][], byte[][]>>();
		for (int i = 0; i < 1000; i++) {
			WeakHashMap<byte[][], byte[][]> d = new WeakHashMap<byte[][], byte[][]>();
			d.put(new byte[1000][1000], new byte[1000][1000]);
			lists.add(d);
			System.gc();
			System.err.println(i);
		}
	}
}
