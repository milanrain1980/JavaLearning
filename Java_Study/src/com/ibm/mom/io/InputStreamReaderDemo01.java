package com.ibm.mom.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderDemo01 {

	public static void main(String[] args) throws Exception {
		File f = new File("C:" + File.separator + "test.txt");
		Reader reader = null;
		reader = new InputStreamReader(new FileInputStream(f));
		
		char[] c = new char[1024];
		int len = reader.read(c);
		reader.close();
		
		System.out.println(new String(c, 0, len));
	}

}
