/**********************************************************
 *                                                        *
 *  CSCI 470/502        Assignment 6           Fall 2018  *
 *                                                        *
 *  Developer(s):  Abdulsalam Olaoye                      *
 *                                                        *
 *                                                        *
 *  Section:  1                                           *
 *                                                        *
 *  Due Date/Time:  10/19/2018   11:59 PM                 *
 *                                                        *
 *  Purpose: An payable interface test App which displays *
 *        some of the properties of the payable interface *
 *        Sub-classes stored in a payable variable array  *
 **********************************************************/
package payableinterfacetest;

// Payable interface test program processing Invoices and 
// Employees polymorphically.
public class PayableInterfaceTest 
{
   public static void main(String[] args)
   {
      // create four-element Payable array
      Payable[] payableObjects = new Payable[6];
      
      // populate array with objects that implement Payable and Employee
      payableObjects[0] = new Invoice("01234", "seat", 2, 375.00);
      payableObjects[1] = new Invoice("56789", "tire", 4, 79.95);
      payableObjects[2] = 
         new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
      payableObjects[3] = 
         new HourlyEmployee("Oriane", "D'almeida", "222-22-2222", 33, 40);
      payableObjects[4] = 
         new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06);
      payableObjects[5] = 
         new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04, 300);


      System.out.println(
         "Invoices and Employees processed polymorphically:"); 

      // generically process each element in array payableObjects
      for (Payable currentPayable : payableObjects)
      {
          
          
         // output currentPayable 
         System.out.printf("%n%s %n", currentPayable.toString());
         
         
            // determine whether element is a BasePlusCommissionEmployee
         if (currentPayable instanceof BasePlusCommissionEmployee) 
         {
            // downcast Employee reference to 
            // BasePlusCommissionEmployee reference
            BasePlusCommissionEmployee employee = 
               (BasePlusCommissionEmployee) currentPayable;

            employee.setBaseSalary(1.10 * employee.getBaseSalary());

            System.out.printf(
               "new base salary with 10%% increase is: $%,.2f%n",
               employee.getBaseSalary());
         } 
         
         // output currentPayable appropriate payment amount
         System.out.printf("%s: $%,.2f%n", "payment due", currentPayable.getPaymentAmount()); 
      } 
   } // end main
} // end class PayableInterfaceTest