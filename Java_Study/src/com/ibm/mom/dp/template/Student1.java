package com.ibm.mom.dp.template;

public class Student1 extends TestPaper {

	public Student1(String studentName) {
		super(studentName);
	}

	@Override
	protected void chooseAnswer1(String s) {
		System.out.println(this.studentName + " is quickly giving the following answer: ");
		System.out.println(s);
	}

	@Override
	protected void chooseAnswer2(String s) {
		System.out.println(this.studentName + " is quickly giving the following answer: ");
		System.out.println(s);
	}

}
