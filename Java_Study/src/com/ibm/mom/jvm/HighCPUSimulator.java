package com.ibm.mom.jvm;

public class HighCPUSimulator {
	private final static int NB_ITERATIONS = 500000000;

	// ~1 KB data footprint
	private final static String DATA_PREFIX = "datadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadata";

	public static void main(String[] args) {
		System.out.println("HIGH CPU Simulator 1.0");

		try {
			for (int i = 0; i < NB_ITERATIONS; i++) {
				// Perform some String manipulations to slow down and expose
				// looping process...
				String data = DATA_PREFIX + i;
			}
		} catch (Throwable any) {
			System.out.println("Unexpected Exception! " + any.getMessage() + " [" + any + "]");
		}
		System.out.println("HighCPUSimulator done!");
	}
}
