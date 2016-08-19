package com.javacodegeeks.patterns.observerpattern;

import java.util.Observable;

public class CommentaryObjectObservable extends Observable implements Commentary {
	private final String subjectDetails;

	public CommentaryObjectObservable(String subjectDetails) {
		this.subjectDetails = subjectDetails;
	}

	@Override
	public void setDesc(String desc) {
		setChanged();
		notifyObservers(desc);
	}

	public String subjectDetails() {
		return subjectDetails;
	}
}
