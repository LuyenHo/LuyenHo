
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 2
//Due Date: 05/03/2021
//Date Submitted: 05/02/2021

package lab2p1;

public class HumanGenome {
		
	private String GenomeName;
	private int NumberofGenes;
	private int NumberofChromosomes;
	private int NumberofCells;
	
	public HumanGenome(){
		GenomeName = " ";
		NumberofGenes = 0;
		NumberofChromosomes = 0;
		NumberofCells = 0;
	}
	
	public void setGenomeName (String name) { 
		GenomeName = name;
	}
	
	public void setNumberofGenes (int genNum) {
		NumberofGenes = genNum;
	}
	
	public void setNumberofChromosomes (int chroNum) {
		NumberofChromosomes = chroNum;
	}
	
	public void setNumberofCells (int cellNum) {
		NumberofCells = cellNum;
	}
	
	public String getGenomeName () {
		return GenomeName;
	}
	
	public int getNumberofGenes () {
		return NumberofGenes;
	}
	
	public int getNumberofChromosomes () {
		return NumberofChromosomes;
	}
	
	public int getNumberofCells () {
		return NumberofCells;
	}
	
	public void display () {
		System.out.print("\nHuman " + GenomeName + "\n");
		System.out.print("Number of Genes: " + NumberofGenes + "\n");
		System.out.print("Number of Chromosomes: " + NumberofChromosomes + "\n");
		System.out.print("Number of Cells: " + NumberofCells + " Trillions\n");
	}

}
