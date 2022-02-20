
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 3
//Due Date: 05/13/2021
//Date Submitted: 05/12/2021

package lab3;

import java.util.Scanner;

public class GenomeInput {
	
	public HumanGenome InputGenome() {
		Scanner in = new Scanner(System.in);
		
		HumanGenome Genome = new HumanGenome();
		String name;
		int genNum, chroNum, cellNum;
		
		System.out.print("Enter a name: ");
		name = in.nextLine();
		
		System.out.print("Enter number of genes: ");
		genNum = in.nextInt();
		
		System.out.print("Enter number of chromosomes: ");
		chroNum = in.nextInt();
		
		System.out.print("Enter number of cells: ");
		cellNum = in.nextInt();
		in.close();
		
		Genome.setGenomeName(name);
		Genome.setNumberofGenes(genNum);
		Genome.setNumberofChromosomes(chroNum);
		Genome.setNumberofCells(cellNum);
		
		return  Genome;
	
	}

	public static void main(String[] args) {
		HumanGenome Genome;
		GenomeInput input  = new GenomeInput();
		Genome = input.InputGenome();
		Genome.display();

	}

}

