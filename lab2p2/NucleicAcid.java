
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 2
//Due Date: 05/03/2021
//Date Submitted: 05/02/2021

package lab2p2;

public class NucleicAcid {
	private String Name;
	private String ChemicalFormula;
	private float Molarmass;
	private float Density;
	
	public NucleicAcid(){
		Name = " ";
		ChemicalFormula = " ";
		Molarmass = 0;
		Density = 0;
	}
	
	public void setName (String name) { 
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
	
	public String getName() {
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
		System.out.printf("\n%-20s%s", "Nucleic Acids Name:", Name);
		System.out.printf("\n%-20s%s", "Chemical Formula:", ChemicalFormula);
		System.out.printf("\n%-20s%s g/mol", "Molar Mass:", Molarmass);
		System.out.printf("\n%-20s%s g/cm3", "Density:", Density);
	}

}
