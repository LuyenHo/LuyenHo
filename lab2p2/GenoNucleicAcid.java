
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 2
//Due Date: 05/03/2021
//Date Submitted: 05/02/2021

package lab2p2;

import java.util.Scanner;

public class GenoNucleicAcid {
	
	public NucleicAcid InputNA() {
		Scanner in = new Scanner(System.in);
		
		NucleicAcid NA_Input = new NucleicAcid();
		String name, ChemFor;
		float Mola, Den;
		
		System.out.print("Enter Nucleic Acids Name: ");
		name = in.nextLine();
		
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

/*~*~* 
output

Enter Nucleic Acids Name: Cytosine
Enter Chemical Formula: C4H5N3O
Enter Molar Mass (g/mol): 111.10
Enter Density (g/cm3): 1.55

Nucleic Acids Name: Cytosine
Chemical Formula:   C4H5N3O
Molar Mass:         111.1 g/mol
Density:            1.55 g/cm3

Enter Nucleic Acids Name: Adenine
Enter Chemical Formula: C5H5N5
Enter Molar Mass (g/mol): 135.13
Enter Density (g/cm3): 1.6

Nucleic Acids Name: Adenine
Chemical Formula:   C5H5N5
Molar Mass:         135.13 g/mol
Density:            1.6 g/cm3

Enter Nucleic Acids Name: Guanine
Enter Chemical Formula: C5H5N5O
Enter Molar Mass (g/mol): 151.13
Enter Density (g/cm3): 2.200

Nucleic Acids Name: Guanine
Chemical Formula:   C5H5N5O
Molar Mass:         151.13 g/mol
Density:            2.2 g/cm3

Enter Nucleic Acids Name: Uracil
Enter Chemical Formula: C4H4N2O2
Enter Molar Mass (g/mol): 112.08676
Enter Density (g/cm3): 1.32

Nucleic Acids Name: Uracil
Chemical Formula:   C4H4N2O2
Molar Mass:         112.08676 g/mol
Density:            1.32 g/cm3

*~*~*/