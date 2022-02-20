
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 4
//Due Date: 05/25/2021
//Date Submitted: 05/25/2021

package acct;

public class SpecialSavings extends SavingsAccount {
	public SpecialSavings(double savingsBalance) {
		super(savingsBalance);
		}
	@Override
	public void calculateMonthlyInterest() {
		double balance = getSavingsBalance();
		if(balance >10000){
			modifyInterestRate(0.10);
			} else {
				modifyInterestRate(0.04);
				}
		super.calculateMonthlyInterest();
		}
	@Override
	public void withdraw(double amount) {
		super.withdraw(amount);
		}
	@Override
	public void deposit(double amount) {
		super.deposit(amount);
		}
		   
	}
