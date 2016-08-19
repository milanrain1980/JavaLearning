package com.ibm.mom.runtime;

import java.io.IOException;

public class RuntimeDemo03 {

	public static void main(String[] args) {
		Runtime run = Runtime.getRuntime();
		
		Process process = null;
		
		try {
			process = run.exec("notepad.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		process.destroy();
	}

}
