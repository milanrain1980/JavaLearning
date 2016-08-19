package com.ibm.mom.random;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class DoubleColorBallDraw {

	public static void main(String[] args) throws Exception {
		// Create file to store every result
		File f = new File("C:" + File.separator + "DoubleColorBall.txt");
		FileWriter fw = new FileWriter(f, true);
		
		
		Random r = new Random();
		int blueBallCount = 18;
		Integer blueBallNo = 0;
//		int redBallCount = 1;
//		Integer redBallNo = 0;
		Set<Integer> blueBallSet = new TreeSet<Integer>();
		
		for (int i =0; i < blueBallCount; i++) {
			blueBallNo = r.nextInt(33) + 1;
			if (blueBallSet.contains(blueBallNo)) {
				blueBallCount ++;
			} else {
				blueBallSet.add(blueBallNo);
			}
		}
		
		fw.write("\r\n");
		
		System.out.println("The lucky blue ball numbers are listed as follows:");
		// Print the all the blue ball according to the natural order.
		for (Iterator<Integer> iter = blueBallSet.iterator(); iter.hasNext();) {
			fw.write(String.valueOf(iter.next()) + "\t");
//			System.out.println(iter.next());
		}
		
		fw.write("\t");
		
		System.out.println("The lucky red ball number is listed as follows:");
		fw.write(String.valueOf(new Random().nextInt(16) + 1));
//		System.out.println(new Random().nextInt(16) + 1);
		
		fw.write("\r");
		fw.write("===================================================================================");
		fw.write("\r\n");
		
		fw.close();
	}

}
