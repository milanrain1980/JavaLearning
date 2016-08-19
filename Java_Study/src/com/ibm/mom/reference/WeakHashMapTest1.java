package com.ibm.mom.reference;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/**
 * WeakHashMap����Ҫͨ��expungeStaleEntries�����������ʵ���Ƴ����ڲ����õ���Ŀ�Ӷ��ﵽ���Զ��ͷ��ڴ��Ŀ�ĵ�
 * .������ֻҪ��WeakHashMap�����ݽ��з��ʾͻ��������������Ӷ��ﵽ������ڲ�����Ϊ�ⲿ���õ���Ŀ��
 * �������Ԥ��������WeakHashMap������GC��ǰ�ֲ������ʸ�WeakHashMap,�ǲ��ǾͲ����ͷ��ڴ�����
 * 
 * ����JavaĬ���ڴ���64M�������ڲ��ı��ڴ����������£��ò����ܲ��˼���ѭ�����ڴ�����ˡ�
 * ������Ȼ��WeakHashMap���ʱ��û���Զ��������ͷŲ��õ��ڴ档
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
