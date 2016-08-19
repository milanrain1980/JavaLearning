package com.ibm.mom.array;

public class ArrayDemo1 {

	public static void main(String[] args) {
		int [][] array = {
				{11, 12},
				{21, 22, 23},
				{31, 32, 33, 34, 35}
		};
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
