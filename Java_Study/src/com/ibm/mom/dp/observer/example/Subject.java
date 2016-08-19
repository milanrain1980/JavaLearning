package com.ibm.mom.dp.observer.example;

/**
 * ���۲��߽ӿ�
 *
 * @author ligang
 *
 */
public interface Subject {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	
	/**
	 * ֪ͨ���й۲��߸�����Ϣ
	 */
	public void notifyObservers();
	
}
