package com.ibm.mom.concurrency;

import java.util.concurrent.atomic.AtomicReferenceArray;

public class AtomicReferenceArrayExample {

	public static void main(String[] args) {
//		AtomicReferenceArray array = new AtomicReferenceArray(10);

/*		Object[] source = new Object[10];
		source[5] = "Some string";
		AtomicReferenceArray array = new AtomicReferenceArray(source);

		Object element = array.get(5);
		
		array.set(5, "another object");*/
		
		
/*		String[] source = new String[10];
		source[5] = "Some string";
		AtomicReferenceArray<String> array = new AtomicReferenceArray<String>(source);*/

		String string1 = "string1";
		String string2 = "string2";
		    
		String[] source = new String[10];
		source[5] = string1;
		AtomicReferenceArray<String> array = new AtomicReferenceArray<String>(source);
		    
		array.compareAndSet(5, string1, string2);
	}

}
