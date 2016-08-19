package com.ibm.mom.dp.template;

public abstract class TestPaper {
	protected String studentName;
	
	public TestPaper(String studentName) {
		super();
		this.studentName = studentName;
	}

	abstract protected void chooseAnswer1(String s);
	abstract protected void chooseAnswer2(String s);
	
	protected void listQuestion1() {
		System.out.println("Please choose one answer(A,B,C,D) from Question 1:");
	}
	
	protected void listQuestion2() {
		System.out.println("Please choose one answer(A,B,C,D) from Question 2:");
	}
	
	public final void showPaper(String answer1, String answer2) {
		this.listQuestion1();
		this.chooseAnswer1(answer1);
		this.listQuestion2();
		this.chooseAnswer2(answer2);
	}
}
