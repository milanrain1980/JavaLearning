package com.ibm.mom.dp.observer.example1;

public class ObserverTest {

	public static void main(String[] args) {
		// 创建主题对象
		ConcreteSubject subject = new ConcreteSubject();
		
		// 创建观察者对象
		Observer observer1 = new ConcreteObserver();
		Observer observer2 = new ConcreteObserver();
		Observer observer3 = new ConcreteObserver();
		
		// 将观察者对象登记到主题对象上
		subject.attach(observer1);
		subject.attach(observer2);
		subject.attach(observer3);
		
		// 改变主题对象的状态
		subject.change("new state");
	}

}
