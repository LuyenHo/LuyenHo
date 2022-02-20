
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 6
//Due Date: 06/16/2021
//Date Submitted: 06/16/2021

package adapter;

import java.io.IOException;
import exception.StudentGradingException;
import model.Statistics;
import model.Student;
import model.StudentGrade;
import util.FileIO;

public abstract class StudentAPIImplble implements StudentAPI {

	// method to print statistics
	public void printStatistics(String filename, Student[] students) {
		
		Statistics newStatistics = new Statistics();

		newStatistics.findlow(students);
		newStatistics.findhigh(students);
		newStatistics.findavg(students);

		// Print the data and statistics
		newStatistics.displayStatistics(1);
		newStatistics.displayStatistics(2);
		newStatistics.displayStatistics(3);
	}

	// method to print score
	public void printScore(int SID) {
		String filename = "Report_" + SID + ".ser";
		StudentGrade studentGrade;
		try {
			studentGrade = FileIO.gradeReader(filename);
			System.out.printf("\tScores for " + SID + ": ");
			for (int i = 0; i < 5; i++) {
				System.out.printf(studentGrade.getStudents().getScores()[i] + " ");
			}
			System.out.println();
		} catch (IOException exception) {

		} catch (StudentGradingException exception) {
			System.out.println(exception.toString());
		}
	}

}
