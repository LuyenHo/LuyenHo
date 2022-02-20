
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 6
//Due Date: 06/16/2021
//Date Submitted: 06/16/2021

package adapter;

import model.Student;

public interface StudentAPI {
	
	public void printStatistics(String filename, Student[] students);

	public void printScore(int SID);

}
