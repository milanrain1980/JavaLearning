package com.ibm.mom.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Hashtable;

public class EmployeeCache {
	private static EmployeeCache cache;											// һ��Cacheʵ��
	private Hashtable<String, EmployeeRef> employeeRefs;			// ����Cache���ݵĴ洢
	private ReferenceQueue<Employee> rq;										// ����Reference�Ķ���

	// �̳�SoftReference��ʹ��ÿһ��ʵ�������п�ʶ��ı�ʶ��
	private class EmployeeRef extends SoftReference<Employee> {
		private String _key = "";

		public EmployeeRef(Employee em, ReferenceQueue<Employee> q) {
			super(em, q);
			_key = em.getId();
		}
	}

	// ����һ��������ʵ��
	private EmployeeCache() {
		employeeRefs = new Hashtable<String, EmployeeRef>();
		rq = new ReferenceQueue<Employee>();
	}

	// ȡ�û�����ʵ��
	public static EmployeeCache getInstance() {
		if (cache == null) {
			cache = new EmployeeCache();
		}
		return cache;
	}

	// �������õķ�ʽ��һ��Employee�����ʵ���������ò����������
	private void cacheEmployee(Employee em) {
		cleanCache();				// �����������
		EmployeeRef ref = new EmployeeRef(em, rq);
		employeeRefs.put(em.getId(), ref);
	}

	// ������ָ����ID�ţ����»�ȡ��ӦEmployee�����ʵ��
	public Employee getEmployee(String ID) {
		Employee em = null;
		// �������Ƿ��и�Employeeʵ���������ã�����У�����������ȡ�á�
		if (employeeRefs.containsKey(ID)) {
			EmployeeRef ref = (EmployeeRef) employeeRefs.get(ID);
			em = (Employee) ref.get();
		}

		// ���û�������ã����ߴ��������еõ���ʵ����null�����¹���һ��ʵ����
		// �����������½�ʵ����������
		if (em == null) {
			em = new Employee(ID);
			System.out.println("Retrieve From EmployeeInfoCenter. ID=" + ID);
			this.cacheEmployee(em);
		}
		return em;
	}

	private void cleanCache() {
		EmployeeRef ref = null;
		while ((ref = (EmployeeRef) rq.poll()) != null) {
			employeeRefs.remove(ref._key);
		}
	}

	// ���Cache�ڵ�ȫ������
	public void clearCache() {
		cleanCache();
		employeeRefs.clear();
		System.gc();
		System.runFinalization();
	}

}
