/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savingsaccountapp;

/**
 *
 * @author manpu_000
 */
public class SavingsAccount {
    
    private static double annualInterestRate;
    private double savingsBalance;
    
    public SavingsAccount(double interest, double balance )
    {
        annualInterestRate = interest;
        savingsBalance = balance;
    }
    
    public double calculateMonthlyInterest()
    {
        
        setSavingsBalance(getSavingsBalance() +((getSavingsBalance() * getAnnualInterestRate())/ 12));
        
        return getSavingsBalance();
    } 
    
    public double getSavingsBalance()
    {
        return savingsBalance;
    }
    
    public double getAnnualInterestRate()
    {
        return annualInterestRate;
    }
    
    public void setSavingsBalance(double balance)
    {
        savingsBalance = balance;
    }
    
    public static void modifyInterestRate(double interest)
    {
        annualInterestRate= interest;
    }
}
