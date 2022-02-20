
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 4
//Due Date: 05/25/2021
//Date Submitted: 05/25/2021

package acct;

public class SavingsAccount {
	private double savingsBalance;
	private static double annualInterestRate = 0;

	public SavingsAccount(double savingsBalance) {
       this.savingsBalance = savingsBalance;
	   }

	public void calculateMonthlyInterest() {
		savingsBalance += (savingsBalance*annualInterestRate)/12;
	}

	public static void modifyInterestRate(double newInterestRate) {
		annualInterestRate = newInterestRate;
	}

	public void withdraw(double amount) {
       savingsBalance -= amount;
	}

	public void deposit(double amount) {
       savingsBalance += amount;
	}
	
	protected double getSavingsBalance() {
       return savingsBalance;
    }

	protected void setSavingsBalance(double savingsBalance) {
       this.savingsBalance = savingsBalance;
	}
	
	protected double getAnnualInterestRate(){
		return annualInterestRate;
	}
	
}
