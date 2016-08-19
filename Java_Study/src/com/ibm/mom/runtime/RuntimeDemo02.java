package com.ibm.mom.runtime;

import java.io.IOException;

public class RuntimeDemo02 {

	public static void main(String[] args) {
		Runtime run = Runtime.getRuntime();
		
		try {
			run.exec("notepad.exe");
			run.exec("msconfig");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
