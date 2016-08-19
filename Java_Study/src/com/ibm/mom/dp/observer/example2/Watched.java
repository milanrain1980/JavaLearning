package com.ibm.mom.dp.observer.example2;

import java.util.Observable;

public class Watched extends Observable {
	private String data = "";

	public String getData() {
		return data;
	}

	public void setData(String data) {
		if (!this.data.equals(data)) {
			this.data = data;
			setChanged();
		}
		
		notifyObservers();
	}
}
