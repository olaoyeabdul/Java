/**********************************************************
 *                                                        *
 *  CSCI 470/502        Assignment 6            Fall 2018 *
 *                                                        *
 *  Class Name:  BasePlusCommissionEmployee               *
 *                                                        *
 *  Developer(s):  Abdulsalam I Olaoye                    *
 *                                                        *
 *  Purpose: BasePlusCommissionEmployee class implements  *
 *           methods and properties a Base plus commission*
 *           employee would possess and the class is a    *
 *                 CommissionEmployee sub-class           *
 **********************************************************/
package payableinterfacetest;

// BasePlusCommissionEmployee class extends CommissionEmployee.

public class BasePlusCommissionEmployee extends CommissionEmployee 
{
   private double baseSalary; // base salary per week

   // constructor
   public BasePlusCommissionEmployee(String firstName, String lastName, 
      String socialSecurityNumber, double grossSales,
      double commissionRate, double baseSalary)
   {
      super(firstName, lastName, socialSecurityNumber, 
         grossSales, commissionRate);

      if (baseSalary < 0.0) // validate baseSalary                  
         throw new IllegalArgumentException("Base salary must be >= 0.0");
            
      this.baseSalary = baseSalary;                
   }

   // set base salary
   public void setBaseSalary(double baseSalary)
   {
      if (baseSalary < 0.0) // validate baseSalary                  
         throw new IllegalArgumentException("Base salary must be >= 0.0");
            
      this.baseSalary = baseSalary;                
   } 

   // return base salary
   public double getBaseSalary()
   {
      return baseSalary;
   }

     // calculates payment amount and returns it; override interface method getPaymentAmount in Payable
   @Override                                                            
   public double getPaymentAmount()                                             
   {                                                                    
      return getBaseSalary() + super.getPaymentAmount();                        
   } 

   // return String representation of BasePlusCommissionEmployee object
   @Override                                                           
   public String toString()                                            
   {                                                                   
      return String.format("%s %s; %s: $%,.2f",                       
         "base-salaried", super.toString(),                            
         "base salary", getBaseSalary());                             
   } 
} // end class BasePlusCommissionEmployee