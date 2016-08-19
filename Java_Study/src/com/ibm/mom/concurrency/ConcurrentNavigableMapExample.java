package com.ibm.mom.concurrency;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentNavigableMapExample {

	public static void main(String[] args) {
		ConcurrentNavigableMap<String, String> map = new ConcurrentSkipListMap<String, String>();

		map.put("1", "one");
		map.put("2", "two");
		map.put("3", "three");

		ConcurrentNavigableMap headMap = map.headMap("2");
		ConcurrentNavigableMap tailMap = map.tailMap("2");
		ConcurrentNavigableMap subMap = map.subMap("2", "3");
	}

}
