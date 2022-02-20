
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 2
//Due Date: 05/03/2021
//Date Submitted: 05/02/2021

package lab2p1;

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


/*~*~* 
output

Enter a name: Bob
Enter number of genes: 20000
Enter number of chromosomes: 46
Enter number of cells: 76

Human Bob
Number of Genes: 20000
Number of Chromosomes: 46
Number of Cells: 76 Trillions


Enter a name: Sally
Enter number of genes: 20000
Enter number of chromosomes: 46
Enter number of cells: 120

Human Sally
Number of Genes: 20000
Number of Chromosomes: 46
Number of Cells: 120 Trillions


Enter a name: Sri
Enter number of genes: 20000
Enter number of chromosomes: 46
Enter number of cells: 75

Human Sri
Number of Genes: 20000
Number of Chromosomes: 46
Number of Cells: 75 Trillions

 
*~*~*/