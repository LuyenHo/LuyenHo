
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 4
//Due Date: 05/25/2021
//Date Submitted: 05/25/2021

package acct;

public class Driver2 {
	 public static void main(String[] args) {
		 
		 SavingsAccount saver1 = new SpecialSavings(2000.00);
		 SavingsAccount saver2 = new SpecialSavings(3000.00);
		 saver1.calculateMonthlyInterest();
		 saver2.calculateMonthlyInterest();
		 System.out.printf("Saver 1 balance: %.2f\nInterest earned: %.0f", saver1.getSavingsBalance(), saver1.getAnnualInterestRate()*100);
	     System.out.println((char)37);
	     System.out.printf("\nSaver 2 balance: %.2f\nInterest earned: %.0f", saver2.getSavingsBalance(), saver2.getAnnualInterestRate()*100);
	     System.out.println((char)37);
	     
	     System.out.println("\n\nAfter deposit in both the accounts");
	     saver1.deposit(6700);
	     saver1.calculateMonthlyInterest(); //pays 4%
	     System.out.printf("Saver 1 balance: %.2f\nInterest earned: %.0f", saver1.getSavingsBalance(), saver1.getAnnualInterestRate()*100);
	     System.out.println((char)37);
	     saver2.deposit(12500);
	     saver2.calculateMonthlyInterest(); //pays 10%
	     System.out.printf("\nSaver 2 balance: %.2f\nInterest earned: %.0f", saver2.getSavingsBalance(), saver2.getAnnualInterestRate()*100);
	     System.out.println((char)37);
	     
	     System.out.println("\n\nAfter withdraw in both the accounts");
	     saver1.withdraw(2000);
	     saver1.calculateMonthlyInterest(); //pays 4%
	     System.out.printf("Saver 1 balance: %.2f\nInterest earned: %.0f", saver1.getSavingsBalance(), saver1.getAnnualInterestRate()*100);
	     System.out.println((char)37);
	     saver2.withdraw(6000);
	     saver2.calculateMonthlyInterest(); //pays 4%
	     System.out.printf("\nSaver 2 balance: %.2f\nInterest earned: %.0f", saver2.getSavingsBalance(), saver2.getAnnualInterestRate()*100);
	     System.out.println((char)37);
	}

}

/*~*~* 
output

Saver 1 balance: 2006.67
Interest earned: 4%

Saver 2 balance: 3010.00
Interest earned: 4%


After deposit in both the accounts
Saver 1 balance: 8735.69
Interest earned: 4%

Saver 2 balance: 15639.25
Interest earned: 10%


After withdraw in both the accounts
Saver 1 balance: 6758.14
Interest earned: 4%

Saver 2 balance: 9671.38
Interest earned: 4%



*~*~*/
