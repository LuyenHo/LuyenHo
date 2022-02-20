
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 3
//Due Date: 05/13/2021
//Date Submitted: 05/12/2021

package lab3;

import java.util.Scanner;

public class GenoNucleicAcid {
	
	public NucleicAcid InputNA() {
		Scanner in = new Scanner(System.in);
		
		NucleicAcid NA_Input = new NucleicAcid();
		String ChemFor;
		char name;
		float Mola, Den;
		
		System.out.print("Enter Nucleic Acids Name: ");
		name = in.next().charAt(0); //I have little change in this line to fit the program
		
		System.out.print("Enter Chemical Formula: ");
		ChemFor = in.nextLine();
		
		System.out.print("Enter Molar Mass (g/mol): ");
		Mola = in.nextFloat();
		
		System.out.print("Enter Density (g/cm3): ");
		Den = in.nextFloat();
		in.close();
		
		NA_Input.setName(name);
		NA_Input.setChemicalFormula(ChemFor);
		NA_Input.setMolarmass(Mola);
		NA_Input.setDensity(Den);
		
		return  NA_Input;
	
	}

	public static void main(String[] args) {
		
		NucleicAcid NA_Input;
		GenoNucleicAcid input  = new GenoNucleicAcid();
		NA_Input = input.InputNA();
		NA_Input.display();

	}

}
