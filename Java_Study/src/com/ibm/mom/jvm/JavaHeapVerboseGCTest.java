package com.ibm.mom.jvm;

import java.util.HashMap;
import java.util.Map;

/**
 * Need to configure the following arguments before running this Java application:
 * 
 * -Xms1024m -Xmx1024m -verbose:gc -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:C:/logs/gc.log
 */
public class JavaHeapVerboseGCTest {
	private static Map<String, String> mapContainer = new HashMap<String, String>();
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("Finalizing is working....");
	}

	public static void main(String[] args) {
		System.out.println("Java 7 HotSpot Verbose GC Test Program v1.0");
		String stringDataPrefix = "stringDataPrefix";
		
		// Load Java Heap with 3 M java.lang.String instances
		for (int i = 0; i < 3000000; i++) {
			String newStringData = stringDataPrefix + i;
			mapContainer.put(newStringData, newStringData);
		}
		System.out.println("MAP size: " + mapContainer.size());
		System.gc(); 			// Explicit GC!
		
		// Remove 2 M out of 3 M
		for (int i = 0; i < 2000000; i++) {
			String newStringData = stringDataPrefix + i;
			mapContainer.remove(newStringData);
		}
		System.out.println("MAP size: " + mapContainer.size());
		System.gc();
		
		System.out.println("End of program!");
	}
	
}