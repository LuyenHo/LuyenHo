
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 6
//Due Date: 16/16/2021
//Date Submitted: 06/16/2021

package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;

import exception.StudentGradingException;
import model.Student;
import model.StudentGrade;

public class FileIO {
	public static int counter;
	public static String header[];

	// default constructor
	public FileIO() {
		counter = 0;
		header = new String[6];
	}

	// getters
	public static int getCounter() {
		return FileIO.counter;
	}

	public static String[] getHeader() {
		return FileIO.header;
	}

	public static Student[] readFile(String filename, Student[] students) throws StudentGradingException {
		// Reads the file and builds student array.

		try {
			FileReader fileReader = new FileReader(filename);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			boolean eof = false;

			while (!eof) {
				String line = bufferedReader.readLine();

				if (line == null)
					eof = true;
				else {
					counter++;

					if (counter == 1) {
						header = line.split(" ");
					}

					if (counter > 1) {
						students[counter - 2] = new Student();
						StringTokenizer st = new StringTokenizer(line);
						while (st.hasMoreTokens()) {
							students[counter - 2].setSID(Integer.parseInt(st.nextToken()));

							int[] score = new int[5]; // stores scores

							for (int j = 0; j < 5; j++) {
								score[j] = Integer.parseInt(st.nextToken());
							}

							students[counter - 2].setScores(score);
						}
					}

					if (counter > 40)
						break;
				}
			}
			bufferedReader.close();

		} catch (NumberFormatException exception) {
			throw new StudentGradingException(1, "NumberFormatException");
		} catch (Exception exception) {
			throw new StudentGradingException(404, exception.toString());
		}

		// return the students
		return students;
	}

	// method for grade writer
	public static void gradeWriter(StudentGrade studentGrade) throws StudentGradingException, IOException {
		ObjectOutputStream out = null;
		try {
			String filename = "Report_" + studentGrade.getSID() + ".ser";
			out = new ObjectOutputStream(new FileOutputStream(filename));
			System.out.println("Created file: " + filename);
			out.writeObject(studentGrade);
		} catch (IOException e) {
			if (out != null)
				out.close();
			throw new StudentGradingException(102, e.toString());
		}
		if (out != null)
			out.close(); // closing
	}

	// method for grade reader
	public static StudentGrade gradeReader(String filename) throws StudentGradingException, IOException {
		ObjectInputStream in;
		StudentGrade studentGrade;
		try {
			in = new ObjectInputStream(new FileInputStream(filename));
		} catch (FileNotFoundException exception) {
			throw new StudentGradingException(123, exception.toString());
		} catch (IOException exception) {
			throw new StudentGradingException(456, exception.toString());
		}

		try {
			studentGrade = (StudentGrade) in.readObject();
		} catch (ClassNotFoundException exception) {
			in.close();
			throw new StudentGradingException(592, exception.toString());
		}
		in.close();
		return studentGrade;
	}

	public static void displayHeader() { // print statistics for all students and all quizzes
		System.out.printf("\tNumber\t" + header[0]);
		for (int i = 1; i < 6; i++) {
			System.out.print("\t  " + header[i]);
		}
		System.out.printf("\n\t======\t====\t ===\t ===\t ===\t ===\t ===\n");
	}
}
