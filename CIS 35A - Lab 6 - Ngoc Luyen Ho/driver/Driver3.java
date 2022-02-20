
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 6
//Due Date: 06/16/2021
//Date Submitted: 06/16/2021

package driver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import adapter.SAPI;
import adapter.StudentAPI;
import exception.StudentGradingException;
import model.Statistics;
import model.Student;
import model.StudentGrade;
import util.FileIO;

public class Driver3 {

	public static void main(String[] args) throws StudentGradingException {
		
				Scanner in = new Scanner(System.in);

				// create new object of students
				Student[] students = new Student[40];
				String filename;
				
				System.out.print("Enter data file's name: ");
				filename = in.nextLine();
				in.close();

				// create new object of class statistics
				Statistics statistics = new Statistics();
				
				try {
					students = FileIO.readFile(filename, students);
				} catch (StudentGradingException exception) {
					exception.writeToFile();
				}

				// Array list of student grade
				ArrayList<StudentGrade> grades = new ArrayList<StudentGrade>();
				for (Student student : students) {
					if (student == null)
						break;
					grades.add(new StudentGrade(student, statistics, students));
				}
				for (StudentGrade studentGrade : grades) {
					try {
						FileIO.gradeWriter(studentGrade);
						FileIO.gradeReader("Report_" + studentGrade.getSID() + ".ser");
					} catch (IOException e) {

					} catch (StudentGradingException e) {
						e.writeToFile();
					}
				}

		// create new object of student API
		StudentAPI studentAPI = new SAPI();

		studentAPI.printStatistics(filename, students);
		studentAPI.printScore(6999);
		studentAPI.printScore(1234);
		studentAPI.printScore(4602);
	}

}

/*~*~* 
output

Enter data file's name: data_2.txt
Created file: Report_1234.ser

	Lowest score :	  52	   7	 100	  78	  34
	Highest score:	  52	   7	 100	  78	  34
	Average score:	52.0	7.0	100.0	78.0	34.0

StudentGradingException [errorno = 123, errormsg = java.io.FileNotFoundException: Report_6999.ser (No such file or directory)
exception.StudentGradingException
	Scores for 1234: 52 7 100 78 34 
StudentGradingException [errorno = 123, errormsg = java.io.FileNotFoundException: Report_4602.ser (No such file or directory)
exception.StudentGradingException


Enter data file's name: data_3.txt
Created file: Report_1234.ser
Created file: Report_2134.ser
Created file: Report_3124.ser
Created file: Report_4532.ser
Created file: Report_5678.ser
Created file: Report_6134.ser
Created file: Report_7874.ser
Created file: Report_8026.ser
Created file: Report_9893.ser
Created file: Report_1947.ser
Created file: Report_2877.ser
Created file: Report_3189.ser
Created file: Report_4602.ser
Created file: Report_5405.ser
Created file: Report_6999.ser

	Lowest score :	   0	   7	   0	  32	  10
	Highest score:	 100	 100	 100	  90	  80
	Average score:	46.0	42.0	70.0	75.0	49.0

	Scores for 6999: 0 98 89 78 20 
	Scores for 1234: 52 7 100 78 34 
	Scores for 4602: 89 50 91 78 60 


*~*~*/
