
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 3
//Due Date: 05/13/2021
//Date Submitted: 05/12/2021

package lab3;

public class DNA {
	
	private NucleicAcid LtoRHelix[];
	private NucleicAcid RtoLHelix[];
	private NucleicAcid Adenine = new NucleicAcid ('A', "C5H5N5", 135.13f, 1.6f);
	private NucleicAcid Thymine = new NucleicAcid ('T', "C5H6N2O2", 126.115f, 1.223f);
	private NucleicAcid Cytosine = new NucleicAcid ('C', "C4H5N3O", 111.10f, 1.55f);
	private NucleicAcid Guanine = new NucleicAcid ('G', "C5H5N5O", 151.13f, 2.200f);
	private int count;
	
	//constructor
	public DNA () {
		LtoRHelix = new NucleicAcid[100];
		RtoLHelix = new NucleicAcid[100];
	}
	
	//overload constructor
	public DNA (String strand) {
		count = strand.length();
		LtoRHelix = new NucleicAcid[count];
		RtoLHelix = new NucleicAcid[count];
		LtoRHelixpopulate(strand);
	}
	
	//this method paire each character in the string with nucleic acid and initialize it to the array
	public void LtoRHelixpopulate(String strand) {
		for (int i = 0; i < strand.length(); i++) {
			if (strand.charAt(i) == 'A') {
				LtoRHelix[i] = Adenine;
				RtoLHelix[i] = Thymine;
			}
			if (strand.charAt(i) == 'T') {
				LtoRHelix[i] = Thymine;
				RtoLHelix[i] = Adenine;
			}
			if (strand.charAt(i) == 'G') {
				LtoRHelix[i] = Guanine;
				RtoLHelix[i] = Cytosine;
			}
			if (strand.charAt(i) == 'C') {
				LtoRHelix[i] = Cytosine;
				RtoLHelix[i] = Guanine;
			}
		}
	}
	
	//This method iterate through each index value and print the properties of each nucleic acid
	public void print() {
		System.out.printf("\nLtoRHelix: ");
		for (int i = 0; i < count; i++) {
			System.out.printf("%c", LtoRHelix[i].getName());
		}
		System.out.printf("\nRtoLHelix: ");
		for (int i = 0; i < count; i++) {
			System.out.printf("%c", RtoLHelix[i].getName());
		}
		System.out.printf("\n\nThere are %d nucleic acid in LtoRHelix", count);
		for (int i = 0; i < count; i++) {
			LtoRHelix[i].display();
		}
		System.out.printf("\n\nThere are %d nucleic acid in RtoLHelix", count);
		for (int i = 0; i < count; i++) {
			RtoLHelix[i].display();
		}
	}
	
	//this method print the index values and highest MolarMass of Nucleic Acid of each array of Objects
	public void highestMolarMass() {
		System.out.printf("\n\nThe highest MolarMass in LtoRHelix is Guanine(151.13 g/mol) at index: ");
		for (int i = 0; i < count; i++) {
			if (LtoRHelix[i].getMolarmass() == 151.13f)
			System.out.printf("%d ", i);
		}
		System.out.printf("\nThe highest MolarMass in RtoLHelix is Guanine(151.13 g/mol) at index: ");
		for (int i = 0; i < count; i++) {
			if (RtoLHelix[i].getMolarmass() == 151.13f)
			System.out.printf("%d ", i);
		}
	}
	
	//this method print the total Density of all Nucleic Acid of each array of Objects
	public void totalDensity() {
		float LtoRHelixtotalDensity = 0, RtoLHelixtotalDensity = 0;
		for (int i = 0; i < count; i++) {
			LtoRHelixtotalDensity = LtoRHelixtotalDensity + LtoRHelix[i].getDensity();
			RtoLHelixtotalDensity = RtoLHelixtotalDensity + RtoLHelix[i].getDensity();
		}
		System.out.println("\n\nThe total Density of all Nucleic Acid in LtoRHelix: " + LtoRHelixtotalDensity + " g/cm3");
		System.out.println("The total Density of all Nucleic Acid in RtoLHelix: " + RtoLHelixtotalDensity + " g/cm3");
	}


}
