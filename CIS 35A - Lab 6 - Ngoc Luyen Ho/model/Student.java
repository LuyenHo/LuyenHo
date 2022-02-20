
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 6
//Due Date: 06/16/2021
//Date Submitted: 06/16/2021

package model;

import java.io.Serializable;

public class Student implements Serializable {
	
	 private static final long serialVersionUID = 1L;
	 private int SID;
	 private int scores[] = new int[5];
	 
	 public Student() {}

	public Student(int sID, int[] scores) {
		super();
		SID = sID;
		this.scores = scores;
	}
	
	public int getSID() {
		return SID;
	}
	public void setSID(int sID) {
		SID = sID;
	}
	public int[] getScores() {
		return scores;
	}
	public void setScores(int[] scores) {
		this.scores = scores;
	}
	 
	public void displayData() {
		System.out.printf("\t%d\t%4d\t%4d\t%4d\t%4d\t%4d\n", SID, scores[0], scores[1], scores[2], scores[3], scores[4]);
	}
	

}
