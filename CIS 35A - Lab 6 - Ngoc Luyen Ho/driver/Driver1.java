
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 6
//Due Date: 06/16/2021
//Date Submitted: 06/16/2021

package driver;

import java.util.Scanner;

import exception.StudentGradingException;
import model.Statistics;
import model.Student;
import util.FileIO;

public class Driver1 {
	public static void main(String[] args) throws StudentGradingException {
		
		Scanner in = new Scanner(System.in);

		// create new object of students
		Student students[] = new Student[40];
		String filename;
		
		System.out.print("Enter data file's name: ");
    	filename = in.nextLine();
    	in.close();

		try {
			FileIO.readFile(filename, students);
		}
		// Student Grading Exception
		catch (StudentGradingException exception) {
			if (exception.getErrorMessage() == "NumberFormatException") {
				exception.fixProblemReadFromConsole(students, FileIO.getCounter() - 2);
				
			}
			exception.writeToFile();
		}

		if (FileIO.getCounter() == 0) {
			System.out.println("\nNo file name " + filename + " check again!");
			return;
		}

		if (FileIO.getCounter() == 1) {
			System.out.println();
			FileIO.displayHeader();
			System.out.println("\nThere is no data in this file");
			return;
		}
		System.out.println("\nHere is the test results of all students:");
		FileIO.displayHeader();
		int count = 1;
		for (int i = 0; i < (FileIO.getCounter() - 1); i++) {
			System.out.print("\t  " + count);
			students[i].displayData();
			count++;
		}

		// create new object of statistics
		Statistics newStatistics = new Statistics();

		newStatistics.findlow(students);
		newStatistics.findhigh(students);
		newStatistics.findavg(students);

		// Print the data and statistics

		newStatistics.displayStatistics(1);

		newStatistics.displayStatistics(2);

		newStatistics.displayStatistics(3);
		
	}

}

/*~*~* 
output

Enter data file's name: data_1.txt

	Number	Stud	  Q1	  Q2	  Q3	  Q4	  Q5
	======	====	 ===	 ===	 ===	 ===	 ===

There is no data in this file

Enter data file's name: data_2.txt

Here is the test results of all students:
	Number	Stud	  Q1	  Q2	  Q3	  Q4	  Q5
	======	====	 ===	 ===	 ===	 ===	 ===
	  1		1234	  52	   7	 100	  78	  34

	Lowest score :	  52	   7	 100	  78	  34
	Highest score:	  52	   7	 100	  78	  34
	Average score:	52.0	7.0	100.0	78.0	34.0
	
	Enter data file's name: data_3.txt

Here is the test results of all students:
	Number	Stud	  Q1	  Q2	  Q3	  Q4	  Q5
	======	====	 ===	 ===	 ===	 ===	 ===
	  1		1234	  52	   7	 100	  78	  34
	  2		2134	  90	  36	  90	  77	  30
	  3		3124	 100	  45	  20	  90	  70
	  4		4532	  11	  17	  81	  32	  77
	  5		5678	  20	  12	  45	  78	  34
	  6		6134	  34	  80	  55	  78	  45
	  7		7874	  60	 100	  56	  78	  78
	  8		8026	  70	  10	  66	  78	  56
	  9		9893	  34	   9	  77	  78	  20
	  10	1947	  45	  40	  88	  78	  55
	  11	2877	  55	  50	  99	  78	  80
	  12	3189	  22	  70	 100	  78	  77
	  13	4602	  89	  50	  91	  78	  60
	  14	5405	  11	  11	   0	  78	  10
	  15	6999	   0	  98	  89	  78	  20

	Lowest score :	   0	   7	   0	  32	  10
	Highest score:	 100	 100	 100	  90	  80
	Average score:	46.0	42.0	70.0	75.0	49.0

Enter data file's name: data_4.txt

Here is the test results of all students:
	Number	Stud	  Q1	  Q2	  Q3	  Q4	  Q5
	======	====	 ===	 ===	 ===	 ===	 ===
	  1		1234	  52	   7	 100	  78	  34
	  2		2134	  90	  36	  90	  77	  30
	  3		3124	 100	  45	  20	  90	  70
	  4		4532	  11	  17	  81	  32	  77
	  5		5678	  20	  12	  45	  78	  34
	  6		6134	  34	  80	  55	  78	  45
	  7		7874	  60	 100	  56	  78	  78
	  8		8026	  70	  10	  66	  78	  56
	  9		9893	  34	   9	  77	  78	  20
	  10	1947	  45	  40	  88	  78	  55
	  11	2877	  55	  50	  99	  78	  80
	  12	3189	  22	  70	 100	  78	  77
	  13	4602	  89	  50	  91	  78	  60
	  14	5405	  11	  11	   0	  78	  10
	  15	6999	   0	  98	  89	  78	  20
	  16	2234	  12	  58	  84	  90	  94
	  17	1544	  59	  17	 750	  68	  64
	  18	3136	  80	  56	  94	  67	  39
	  19	5134	 700	  75	  60	  88	  79
	  20	4772	  61	  37	  88	  62	  57
	  21	5693	  60	  42	  47	  68	  94
	  22	1434	  44	  86	  59	  70	  75
	  23	7477	  70	  90	  66	  88	  74
	  24	2024	  82	  70	  56	  71	  76
	  25	9153	  54	  79	  57	  68	  80
	  26	1277	  95	  50	  78	  68	  65
	  27	3875	  35	  60	  79	  88	  90
	  28	3159	  72	  80	 100	  98	  47
	  29	4903	  79	  60	  51	  78	  70
	  30	6205	  41	  39	  40	  68	  20
	  31	1534	  62	  17	  60	  58	  44
	  32	2434	  70	  46	  80	  67	  40
	  33	2424	  80	  55	  30	  60	  80
	  34	4762	  81	  67	  71	  42	  87
	  35	5998	  30	  42	  55	  68	  74
	  36	6094	  94	  80	  75	  68	  55
	  37	7404	  70	 100	  66	  58	  98
	  38	8306	  90	  30	  46	  58	  66
	  39	9743	  44	  59	  67	  78	  50
	  40	1007	  85	  50	  68	  78	  65

	Lowest score :	   0	   7	   0	  32	  10
	Highest score:	 700	 100	 750	  98	  98
	Average score:	73.0	52.0	84.0	72.0	60.0
	
Enter data file's name: data_5.txt

Here is the test results of all students:
	Number	Stud	  Q1	  Q2	  Q3	  Q4	  Q5
	======	====	 ===	 ===	 ===	 ===	 ===
	  1		1234	  52	   7	 100	  78	  34
	  2		2134	  90	  36	  90	  77	  30
	  3		3124	 100	  45	  20	  90	  70
	  4		4532	  11	  17	  81	  32	  77
	  5		5678	  20	  12	  45	  78	  34
	  6		6134	  34	  80	  55	  78	  45
	  7		7874	  60	 100	  56	  78	  78
	  8		8026	  70	  10	  66	  78	  56
	  9		9893	  34	   9	  77	  78	  20
	  10	1947	  45	  40	  88	  78	  55
	  11	2877	  55	  50	  99	  78	  80
	  12	3189	  22	  70	 100	  78	  77
	  13	4602	  89	  50	  91	  78	  60
	  14	5405	  11	  11	   0	  78	  10
	  15	6999	   0	  98	  89	  78	  20
	  16	2234	  12	  58	  84	  90	  94
	  17	1544	  59	  17	  50	  68	  64
	  18	3136	  80	  56	  94	  67	  39
	  19	5134	 100	  75	  60	  88	  79
	  20	4772	  61	  37	  88	  62	  57
	  21	5693	  60	  42	  47	  68	  94
	  22	1434	  44	  86	  59	  70	  75
	  23	7477	  70	  90	  66	  88	  74
	  24	2024	  82	  70	  56	  71	  76
	  25	9153	  54	  79	  57	  68	  80
	  26	1277	  95	  50	  78	  68	  65
	  27	3875	  35	  60	  79	  88	  90
	  28	3159	  72	  80	 100	  98	  47
	  29	4903	  79	  60	  51	  78	  70
	  30	6205	  41	  39	  40	  68	  20
	  31	3693	  64	  46	  49	  78	  84
	  32	1994	  54	  66	  79	  74	  65
	  33	1567	  55	  60	  78	  88	  55
	  34	2557	  65	  70	  89	  88	  80
	  35	3449	  52	  60	 100	  68	  87
	  36	4702	  79	  70	  81	  68	  60
	  37	5065	  31	  41	  50	  68	  70
	  38	6009	  30	  68	  79	  58	  60
	  39	2454	  22	  38	  74	  90	  84
	  40	1994	  89	  47	  50	  68	  54

	Lowest score :	   0	   7	   0	  32	  10
	Highest score:	 100	 100	 100	  98	  94
	Average score:	54.0	52.0	69.0	75.0	61.0
	
Enter data file's name: data_6.txt
StudentGradingException [errorno = 404, errormsg = java.io.FileNotFoundException: data_6.txt (No such file or directory)

No file name data_6.txt check again!

Enter data file's name: data_7.txt
StudentGradingException [errorno = 404, errormsg = java.io.FileNotFoundException: data_7.txt (No such file or directory)

No file name data_7.txt check again!


*~*~*/
