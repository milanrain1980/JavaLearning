package com.ibm.mom.collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest2 {

	public static void main(String[] args) {
		// add()��remove()������ʧ�ܵ�ʱ����׳��쳣(���Ƽ�)
		Queue<String> queue = new LinkedList<String>();
		// ���Ԫ��
		queue.offer("a");
		queue.offer("b");
		queue.offer("c");
		queue.offer("d");
		queue.offer("e");
		for (String q : queue) {
			System.out.println(q);
		}
		System.out.println("==============================================");
		System.out.println("poll=" + queue.poll()); // ���ص�һ��Ԫ�أ����ڶ�����ɾ��
		for (String q : queue) {
			System.out.println(q);
		}
		System.out.println("==============================================");
		System.out.println("element=" + queue.peek()); // ���ص�һ��Ԫ��,���ǲ����Ƴ�Ԫ��
		for (String q : queue) {
			System.out.println(q);
		}
	}

}
