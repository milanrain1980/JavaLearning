package com.javacodegeeks.patterns.factorymethodpattern;

public abstract class DisplayService {

	public void display() {
		XMLParser parser = this.getParser();
		String msg = parser.parse();
		System.out.println(msg);
	}

	protected abstract XMLParser getParser();

}
