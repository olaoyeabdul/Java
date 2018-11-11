/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savingsaccountapp;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author manpu_000
 */
public class SavingsAccountApp {

  
    public static void main(String[] args) 
    {
        System.out.println("Hello");
        
        ArrayList<SavingsAccount> accounts = new ArrayList<>();
        
        SavingsAccount account_1 = new SavingsAccount(0.04, 1000);
        SavingsAccount account_2 = new SavingsAccount(0.04, 1100);
        SavingsAccount account_3 = new SavingsAccount(0.04, 1200);
        SavingsAccount account_4 = new SavingsAccount(0.04, 1300);
        SavingsAccount account_5 = new SavingsAccount(0.04, 1400);
        
        accounts.add(account_1);
        accounts.add(account_2);
        accounts.add(account_3);
        accounts.add(account_4);
        accounts.add(account_5);
        
        displayBalances(accounts);
       
          SavingsAccount.modifyInterestRate(0.05);
       
        displayBalances(accounts);
       
       
        
    }
    
      public static void displayBalances(ArrayList<SavingsAccount> array)
    {
       DecimalFormat moneyFormat = new DecimalFormat("$###,##0.00");
        System.out.print("\n\n\t\t\t\t\t\tMonthly Interest Growth\n\nAccounts\t");
        for(int i = 0; i < 12; i++)
        {
            System.out.printf("\t\tMonth %d",(i+1));
        }
        System.out.print("\n---------\t");
        for(int i = 0; i < 12; i++)
        {
            System.out.printf("\t---------");
        }
        
         System.out.print("\n");
        for(int i = 0; i < array.size(); i++)
        {
          System.out.print("Account"+(i+1)+"\t");
          System.out.print("\t");
          for(int j = 0; j<12; j++)
              {
                 //System.out.print(" ");
                 System.out.print(moneyFormat.format(array.get(i).calculateMonthlyInterest()));
                 System.out.print("\t");
          
              } System.out.print("\n");
            
        }
    }
    
}
