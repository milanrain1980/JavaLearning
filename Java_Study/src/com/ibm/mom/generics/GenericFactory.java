package com.ibm.mom.generics;

public class GenericFactory<E> {

	Class theClass = null;

	public GenericFactory(Class theClass) {
		this.theClass = theClass;
	}

	public E createInstance() throws IllegalAccessException,
			InstantiationException {
		return (E) this.theClass.newInstance();
	}

	public static void main() throws IllegalAccessException, InstantiationException {
		
		GenericFactory<MyClass> factory = new GenericFactory<MyClass>(MyClass.class);
		MyClass myClassInstance = factory.createInstance();

		GenericFactory<SomeClass> factory2 = new GenericFactory<SomeClass>(SomeClass.class);
		SomeClass someClassInstance = factory2.createInstance();
	}
}

class MyClass{}

class SomeClass{}