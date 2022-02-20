
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 3
//Due Date: 05/13/2021
//Date Submitted: 05/12/2021

package lab3;

//this class have some changes from lab 2,
//I add an overload constructor and change a little bit in the display method

public class NucleicAcid {
	private char Name;
	private String ChemicalFormula;
	private float Molarmass;
	private float Density;
	
	public NucleicAcid(){
		Name = ' ';
		ChemicalFormula = " ";
		Molarmass = 0;
		Density = 0;
	}
	public NucleicAcid(char name, String chem, float mol, float den){
		Name = name;
		ChemicalFormula = chem;
		Molarmass = mol;
		Density = den;
	}
	
	public void setName (char name) { 
		Name = name;
	}
	
	public void setChemicalFormula (String ChemFor) {
		ChemicalFormula = ChemFor;
	}
	
	public void setMolarmass (float Mola) {
		Molarmass = Mola;
	}
	
	public void setDensity (float Den) {
		Density = Den;
	}
	
	public char getName() {
		return Name;
	}
	
	public String getChemicalFormula () {
		return ChemicalFormula;
	}
	
	public float getMolarmass () {
		return Molarmass;
	}
	
	public float getDensity () {
		return Density;
	}
	
	public void display () {
		if (Name == 'A') System.out.printf("\n   Adenine");
		if (Name == 'T') System.out.printf("\n   Thymine");
		if (Name == 'C') System.out.printf("\n   Cytosine");
		if (Name == 'G') System.out.printf("\n   Guanine");
		System.out.printf("\n%-20s%s", "	Chemical Formula:", ChemicalFormula);
		System.out.printf("\n%-20s%s g/mol", "	Molar Mass:", Molarmass);
		System.out.printf("\n%-20s%s g/cm3", "	Density:", Density);
	}

}
