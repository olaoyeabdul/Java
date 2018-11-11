/**********************************************************
 *                                                        *
 *  CSCI 470/502        Assignment 4 part 1    Fall 2018  *
 *                                                        *
 *  Developer(s):  Abdulsalam Olaoye                      *
 *                                                        *
 *                                                        *
 *  Section:  1                                           *
 *                                                        *
 *  Due Date/Time:  9/21/2018   11:59 PM                  *
 *                                                        *
 *  Purpose: USMoney Application which manipulates money  *
 *    components received from user, adds it with another *
 *       USMoney object and returns a new USMoney object  *
 *                                                        * 
 **********************************************************/

package usmoneydemo;

import java.util.Scanner;

public class USMoneyDemo {

    public static void main(String[] args) {
        int xCents = 0;     //Cent value holder for the xObject
        int xDollars = 0 ;  //dollars value holder for the xObject
        
        int yCents = 0;     //Cent value holder for the yObject
        int yDollars = 0;   //dollars value holder for the xObject
        
        
        Scanner input = new Scanner(System.in);     //input object will hold user entries from the console
        
        
        //Prompt user for xCent value
        System.out.print("Enter X cents amount, please enter an amount greater than 0 or your entry will be defaulted to 0: \t");
        xCents = input.nextInt();
        
        //Prompt user for xDollars value
        System.out.print("\nEnter X Dollars amount: \t");
        xDollars = input.nextInt();
        
        //Prompt user for yCent value
        System.out.print("\nEnter Y cents amount, please enter an amount greater than 0 or your entry will be defaulted to 0: \t");
        yCents = input.nextInt();
        
        //Prompt user for yDollars value
        System.out.print("\nEnter y Dollars amount: \t");
        yDollars = input.nextInt();
        
        //Create new objects and instantiate with users values
        USMoney x = new USMoney(xDollars, xCents);
        USMoney y = new USMoney(yDollars, yCents);
        
        //Print out values of created objects
        System.out.printf("\nThe first object has: \t$%d.%d\n", x.getDollars(), x.getCents());
        System.out.printf("The second object has: \t$%d.%d\n", y.getDollars(), y.getCents());
        
        
        //Create a new object to hold the total of the first two objects
        USMoney newMoney = x.plus(y);
        
        //Print out total values after adding both objects, these values are of the newly created object
        System.out.printf("Total of both objects: \t$%d.%d\n", newMoney.getDollars(), newMoney.getCents());
        
        //Print statement to show that the original objects' values remained untouched 
        System.out.printf("The first object has: \t$%d.%d\n", x.getDollars(), x.getCents());
        System.out.printf("The second object has: \t$%d.%d\n", y.getDollars(), y.getCents());
    }
    
}
