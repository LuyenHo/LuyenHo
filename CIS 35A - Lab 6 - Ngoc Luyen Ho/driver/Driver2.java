
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 6
//Due Date: 06/16/2021
//Date Submitted: 06/16/2021

package driver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import exception.StudentGradingException;
import model.Statistics;
import model.Student;
import model.StudentGrade;
import util.FileIO;

public class Driver2 {
	public static void main(String[] args) throws StudentGradingException, IOException {
		
		Scanner in = new Scanner(System.in);
		// create student object
		Student[] students = new Student[40];

		// create Statistics object
		Statistics statistics = new Statistics();
		String filename;
		
		System.out.print("Enter data file's name: ");
		filename = in.nextLine();
		in.close();
		
		try {
			students = FileIO.readFile(filename, students);
		} catch (StudentGradingException e) {
			e.writeToFile();
		}

		// array list of student grade
		ArrayList<StudentGrade> studentGrades = new ArrayList<StudentGrade>();
		for (Student student : students) {
			if (student == null)
				break;
			studentGrades.add(new StudentGrade(student, statistics, students));
		}
		for (StudentGrade sg : studentGrades) {
			try {
				FileIO.gradeWriter(sg);
				FileIO.gradeReader("Report_" + sg.getSID() + ".ser");
			} catch (StudentGradingException e) {
				e.writeToFile();
			}
		}
	}
}

/*~*~* 
output

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


*~*~*/
