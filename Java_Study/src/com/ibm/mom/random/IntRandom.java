package com.ibm.mom.random;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class IntRandom {

	public static void main(String[] args) throws Exception {
		File f = new File("C:/password.txt");
		FileWriter fw = new FileWriter(f);
		Random r = new Random();
		int temp = 0;

		for (int i = 1; i <= 100; i++) {
			temp = r.nextInt(10000);
			
			// ²¹×ãËÄÎ»ÃÜÂë£¡
			if (temp < 10) {
				temp = temp * 1000;
			}	else if (temp < 100) {
				temp = temp * 100;
			}  else if (temp < 1000) {
				temp = temp * 10;
			}
			
			if (i <= 9) { 										// pai001-pai009
				fw.write("pai00" + i + "\t\t " + temp);
			} else if (i >= 10 && i <= 99) { 	// pai010-pai099
				fw.write("pai0" + i + "\t\t " + temp);
			} else { 											// pai100~
				fw.write("pai" + i + "\t\t " + temp);
			}
			fw.write("\r\n");
		}

		fw.flush();
		fw.close();
	}

}
