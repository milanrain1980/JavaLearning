package com.ibm.mom.reference;

public class Employee {
	private String id; // ��Ա�ı�ʶ����
	private String name; // ��Ա����
	private String department; // �ù�Ա���ڲ���
	private String phone; // �ù�Ա��ϵ�绰
	private int salary; // �ù�Աн��
	private String origin; // �ù�Ա��Ϣ����Դ

	// ���췽��
	public Employee(String id) {
		this.id = id;
		getDataFromlnfoCenter();
	}

	// �����ݿ���ȡ�ù�Ա��Ϣ
	private void getDataFromlnfoCenter() {
		// �����ݿ⽨�����Ӿ���ѯ�ù�Ա����Ϣ������ѯ�����ֵ
		// ��name��department��plone��salary�ȱ���
		// ͬʱ��origin��ֵΪ"From DataBase"
		this.name = "AAA";
		this.department = "BBB";
		this.phone = "CCC";
		this.salary = 30000;
		this.origin = "From DataBase";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
}
