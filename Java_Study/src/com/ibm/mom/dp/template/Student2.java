package com.ibm.mom.dp.template;

public class Student2 extends TestPaper {

	public Student2(String studentName) {
		super(studentName);
	}

	@Override
	protected void chooseAnswer1(String s) {
		System.out.println(this.studentName + " is slowly giving the following answer: ");
		System.out.println(s);
	}

	@Override
	protected void chooseAnswer2(String s) {
		System.out.println(this.studentName + " is slowly giving the following answer: ");
		System.out.println(s);
	}

}
