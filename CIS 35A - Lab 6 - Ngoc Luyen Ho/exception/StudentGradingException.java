
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 6
//Due Date: 06/16/2021
//Date Submitted: 06/16/2021

package exception;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import model.Student;

public class StudentGradingException extends Exception {

	private static final long serialVersionUID = 1L;
	private int errorNumber;
	private String errorMessage;

	static Scanner scanner = new Scanner(System.in);

	public StudentGradingException() {
		super();
		printmyproblem();
	}

	public StudentGradingException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
		printmyproblem();
	}

	public StudentGradingException(int errorNumber) {
		super();
		this.errorNumber = errorNumber;
		printmyproblem();
	}

	public StudentGradingException(int errorNumber, String errorMessage) {
		super();
		this.errorNumber = errorNumber;
		this.errorMessage = errorMessage;
		printmyproblem();
	}

	public int getErrorNumber() {
		return errorNumber;
	}

	public void setErrorNumber(int errorNumber) {
		this.errorNumber = errorNumber;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void printmyproblem() {
		System.out.println("StudentGradingException [errorno = " + errorNumber + ", errormsg = " + errorMessage);
	}

	public int fixProblemReadFromConsole(Student[] lab6, int i) {
		System.out.println("Enter SID and 5 scores separated by enter: ");
		int a = Integer.parseInt(scanner.nextLine());
		lab6[i].setSID(a);
		int scores[] = new int[5];
		for (int j = 0; j < 5; j++) {
			scores[j] = Integer.parseInt(scanner.nextLine());
		}
		lab6[i].setScores(scores);

		return a;
	}

	public void writeToFile() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("file_exceptions", true));
			bw.append(errorMessage);
			bw.newLine();
			bw.close();
			
		} catch (IOException e) {
			System.out.println(e.toString());
			System.out.println();
		}
	}
}
