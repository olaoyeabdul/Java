/**********************************************************
 *                                                        *
 *  CSCI 470/502        Assignment 6            Fall 2018 *
 *                                                        *
 *  Class Name:  SalariedEmployee                         *
 *                                                        *
 *  Developer(s):  Abdulsalam I Olaoye                    *
 *                                                        *
 *  Purpose: SalariedEmployee class implements methods and*
 *           properties a salaried employee would possess *
 *               and the class is a Employee sub-class    *
 **********************************************************/
package payableinterfacetest;

// SalariedEmployee class that implements interface Payable.
// method getPaymentAmount.
public class SalariedEmployee extends Employee 
{
   private double weeklySalary;

   // constructor
   public SalariedEmployee(String firstName, String lastName, 
      String socialSecurityNumber, double weeklySalary)
   {
      super(firstName, lastName, socialSecurityNumber); 

      if (weeklySalary < 0.0)
         throw new IllegalArgumentException(
            "Weekly salary must be >= 0.0");

      this.weeklySalary = weeklySalary;
   } 

   // set salary
   public void setWeeklySalary(double weeklySalary)
   {
      if (weeklySalary < 0.0)
         throw new IllegalArgumentException(
            "Weekly salary must be >= 0.0");

      this.weeklySalary = weeklySalary;
   } 

   // return salary
   public double getWeeklySalary()
   {
      return weeklySalary;
   } 

   // calculate earnings; implement interface Payable method that was
   // abstract in superclass Employee                                
   @Override                                                         
   public double getPaymentAmount()                                  
   {                                                                 
      return getWeeklySalary();                                      
   } 

   // return String representation of SalariedEmployee object   
   @Override                                                    
   public String toString()                                     
   {                                                            
      return String.format("salaried employee: %s%n%s: $%,.2f",
         super.toString(), "weekly salary", getWeeklySalary());
   } 
} // end class SalariedEmployee

