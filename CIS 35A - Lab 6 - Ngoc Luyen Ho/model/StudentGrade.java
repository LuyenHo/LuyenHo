
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 6
//Due Date: 06/16/2021
//Date Submitted: 06/16/2021

package model;

import java.io.Serializable;

public class StudentGrade implements Serializable {

	private static final long serialVersionUID = 1L;

	// students
	private Student students;
	// statistics
	private Statistics statistics;
	// array of student
	private Student[] student;

	// constructor for the students
	public StudentGrade(Student students, Statistics statistics, Student[] student) {
		this.students = students;
		this.statistics = statistics;
		this.student = student;
	}

	public Student getStudents() {
		return students;
	}

	public void setStudents(Student students) {
		this.students = students;
	}

	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}

	public Student[] getStudent() {
		return student;
	}

	public void setStudent(Student[] student) {
		this.student = student;
	}

	public int getSID() {
		return students.getSID();
	}

	// method to print highest score
	public void printHighest() {
		statistics.findhigh(student);
		statistics.displayStatistics(1);
	}

	// method to print lowest score
	public void printLowest() {
		statistics.findhigh(student);
		statistics.displayStatistics(2);
	}

	// method to print average score
	public void printAverage() {
		statistics.findhigh(student);
		statistics.displayStatistics(3);
	}

	// method to print statistics
	public void printStatistics() {
		printHighest();
		printLowest();
		printAverage();
	}

	// method to print score
	public void printScores() {
		for (int i = 0; i < 5; i++) {
			System.out.printf(students.getScores()[i] + " ");
		}
	}

	// method to print all score
	public void printAllScores() {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.printf(student[i].getScores()[j] + "\t");
			}
			System.out.println();
		}
	}

}
