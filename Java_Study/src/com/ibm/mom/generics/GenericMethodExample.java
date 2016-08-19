package com.ibm.mom.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericMethodExample {

	public static <T> T addAndReturn(T element, Collection<T> collection){
	    collection.add(element);
	    return element;
	}

	public static void main(String[] args) {
		String stringElement = "stringElement";
		List<String> stringList = new ArrayList<String>();
		String strElement = addAndReturn(stringElement, stringList);    

		Integer integerElement = new Integer(123);
		List<Integer> integerList = new ArrayList<Integer>();
		Integer intElement = addAndReturn(integerElement, integerList);    
	}

}
