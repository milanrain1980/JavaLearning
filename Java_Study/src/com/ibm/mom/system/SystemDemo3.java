package com.ibm.mom.system;

public class SystemDemo3 {

	public static void main(String[] args) {
		System.out.println("System version is: "
				+ System.getProperty("os.name") + " "
				+ System.getProperty("os.version") + " "
				+ System.getProperty("os.arch"));
		
		System.out.println("Current User is: " + System.getProperty("user.name"));
		System.out.println("Current User Directory is : " + System.getProperty("user.home"));
		System.out.println("Current User Working Directory is: " + System.getProperty("user.dir"));
	}

}
