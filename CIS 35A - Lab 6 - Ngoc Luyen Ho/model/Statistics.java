
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 6
//Due Date: 06/16/2021
//Date Submitted: 06/16/2021

package model;

import java.io.Serializable;

public class Statistics implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int[] lowscores= new int[5];
	private int[] highscores= new int[5];
	private float[] avgscores= new float[5];
	
	 // default constructor
    public Statistics() {

    }

    // getters
    public int[] getLow() {
        return lowscores;
    }

    public int[] getHigh() {
        return highscores;
    }

    public float[] getAverage() {
        return avgscores;
    }
	  
	public void findlow(Student[] stu){ // finds low score.
		for(int i = 0; i < 5; i++) {
			int min = 100;
			for(int j = 0; j < stu.length; j++){
				if (stu[j] == null)
					continue;
				if(min > stu[j].getScores()[i]){
					min = stu[j].getScores()[i];
				}
			}
			lowscores[i]= min;
		}
	}
	  
	public void findhigh(Student[] stu){ // find high score
		for(int i = 0; i < 5; i++){
			int max = 0;
			for(int j = 0; j < stu.length; j++){
				if (stu[j] == null)
					continue;
				if(max < stu[j].getScores()[i]) {
					max = stu[j].getScores()[i];
				}
			}
			highscores[i]= max;
		}
	}

	public void findavg(Student[] stu){ // find average score.
		for (int i = 0; i < 5; i++) {
			int sum = 0;
			int count = 0;
			for (int j = 0; j < stu.length; j++) {
				if (stu[j] == null)
				continue;
				sum += stu[j].getScores()[i];
				count++;
			}
			try {
				avgscores[i] = sum / count;
			} catch (ArithmeticException e) {
				avgscores[i] = 0;
			}
		}	
	}
	  
	public void displayStatistics(int i){ // print statistics for all students and all quizes
		if (i == 1)
			System.out.printf("\n\tLowest score :\t%4d\t%4d\t%4d\t%4d\t%4d\n", lowscores[0], lowscores[1], lowscores[2], lowscores[3], lowscores[4]);
		if (i == 2)
			System.out.printf("\tHighest score:\t%4d\t%4d\t%4d\t%4d\t%4d\n", highscores[0], highscores[1], highscores[2], highscores[3], highscores[4]);
		if (i == 3)
			System.out.printf("\tAverage score:\t%3.1f\t%3.1f\t%3.1f\t%3.1f\t%3.1f\n\n", avgscores[0], avgscores[1], avgscores[2], avgscores[3], avgscores[4]);
	}

}
