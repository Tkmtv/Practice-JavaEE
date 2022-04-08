package com;

import java.util.List;

public class Exam extends Student {
	
	public List<Double> grades;

	public Exam() {
		super();
	}

	public List<Double> getGrades() {
		return grades;
	}

	public void setGrades(List<Double> grades) {
		this.grades = grades;
	}
}
