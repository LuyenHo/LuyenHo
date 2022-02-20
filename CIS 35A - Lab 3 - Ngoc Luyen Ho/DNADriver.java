
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 3
//Due Date: 05/13/2021
//Date Submitted: 05/12/2021

package lab3;

import java.util.Scanner;


public class DNADriver {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		String strand;
		
		System.out.print("Enter DNA: ");
		strand = in.nextLine();
		
		DNA DNA_Input = new DNA(strand);
		DNA_Input.print();
		DNA_Input.highestMolarMass();
		DNA_Input.totalDensity();
		
		in.close();
	
		}

}

