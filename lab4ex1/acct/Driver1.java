
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 4
//Due Date: 05/25/2021
//Date Submitted: 05/25/2021

package acct;

public class Driver1 {
	 public static void main(String[] args) {
		SavingsAccount saver1 = new SavingsAccount(2000.00);
		SavingsAccount saver2 = new SavingsAccount(3000.00);
		//Set the annual interest rate to 4%
		SavingsAccount.modifyInterestRate (0.04);
	
		//Calculate monthly interest
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
	
		//Print out the new balances for both savers
		System.out.println("The new balances for each of the savers with 4% of annual interest rate");
		System.out.printf("Saver 1 balance : %.2f", saver1.getSavingsBalance());
		System.out.printf("\nSaver 2 balance : %.2f",saver2.getSavingsBalance());
	
	
		//Change annual interest rate to 5%
		SavingsAccount.modifyInterestRate(0.05);
	
		//Calculate the next month interest rate and print out balances
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		System.out.println("\n\nThe new balances for each of the savers with 5% of annual interest rate");
		System.out.printf("Saver 1 balance: %.2f",saver1.getSavingsBalance());
		System.out.printf("\nSaver 2 balance: %.2f",saver2.getSavingsBalance());
	}

}

/*~*~* 
output

The new balances for each of the savers with 4% of annual interest rate
Saver 1 balance : 2006.67
Saver 2 balance : 3010.00

The new balances for each of the savers with 5% of annual interest rate
Saver 1 balance: 2015.03
Saver 2 balance: 3022.54

*~*~*/
