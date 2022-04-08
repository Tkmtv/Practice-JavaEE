package com;

public class Result extends Exam {

	public double avg;
	public double total;

	public Result() {
		super();
	}

	public void calculateTotal() {
		for (double grade : grades) {
			total += grade;
		}
	}

	public void calculateAvg() {
		for (double grade : grades) {
			avg += grade;
		}
		avg = avg / grades.size();
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		String output = "Student [roll = " + roll + ", name = " + name + "]\n";
		output += "Score [";
		for (double grade : grades) {
			output += "grades = " + grade + ", ";
		}
		output += "]\n";
		output += "Result [avg = " + avg + ", total = " + total + "]\n";
		return output;
	}

}
