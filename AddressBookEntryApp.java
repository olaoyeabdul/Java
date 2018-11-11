/**********************************************************
 *                                                        *
 *  CSCI 470/502        Assignment 5           Fall 2018  *
 *                                                        *
 *  Developer(s):  Abdulsalam Olaoye                      *
 *                                                        *
 *                                                        *
 *  Section:  1                                           *
 *                                                        *
 *  Due Date/Time:  10/12/2018   11:59 PM                 *
 *                                                        *
 *  Purpose: An Address Book processing App which prompts *
 *           client with menu options to either display   *
 *      already existing records, add new contact of exit *
 **********************************************************/


package addressbookentryapp;



import java.io.IOException;
import java.util.Scanner;


public class AddressBookEntryApp {

    
    public static void main(String[] args)
    {
        
        Scanner input = new Scanner(System.in);     //Declare a scanner object
        
        
        //Print Welcome message
        System.out.println("\t\tWelcome to Address Book Application");
        
         
         int option = 0;        //Variable used to choose menu options
        
        //Do while option != 3, 3 is the option to exit program
        while(option != 3)
        {
            displayMenu();      //Display Menu to client
            try 
            {
                option = input.nextInt();       
                
                Validator.menuOption(option);       //Validate client's chosen option

                switch (option) 
                {
                    case 1:    //Display phone book entries
                        System.out.println(AddressBookIO.getEntriesString());
                        break;

                    case 2:    //Add entries
                        addEntry();
                        break;

                }
            } 
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
        } 

        //Print Exit message
        System.out.println("\t\t\t Goodbye.");
        
        input.close();
        
    }
    
    /*************************************************************
     *                                                           *
     * addEntry is used to get client's new address book entries *
     *                      and validate them                    *
     *   The method was implemented to simplify the main method  *
     *                                                           *
     *************************************************************/
    public static void addEntry()
    {
        int count = 1;      //Count is a pseudo boolean used to confirm error from catch blocks
        String name = "";       //var used to store new entry names
        do {

            count = 1;          //re-state value of count after every loop
            
            //Prompt user for name entry 
            System.out.print("Enter Name: ");
            Scanner nameInput = new Scanner(System.in);

            try
            {
                name = nameInput.nextLine();

                //Validate name entry , if entered name is valid, catch block is skipped and loop ends
                Validator.checkName(name);
            } 
            catch (IllegalArgumentException e)
            {
                //else if entered name is invalid, display error message and set count back to 0, loop continues
                System.out.println(e.getMessage());
                count = 0;
            }
        } while (count == 0);       //As long as their's an invalid entry, loop will continue
        
        

        String email = "";      //var used to store new email entry
        do {
            count = 1;          //re-state value of count after every loop
            
            //Prompt user for email entry
            System.out.print("Enter email Address: ");
            Scanner emailInput = new Scanner(System.in);

            try
            {
                email = emailInput.next();

                 //Validate email entry , if entry is valid, catch block is skipped and loop ends
                Validator.checkEmail(email);
            } 
            catch (IllegalArgumentException e) 
            {
                //else if entry is invalid, display error message and set count back to 0, loop continues
                System.out.println(e.getMessage());
                count = 0;
            }
        } while (count == 0);       //As long as their's an invalid entry, loop will continue
        
        

        String cellNumber = "";     //Var used to store new cellNumber entry
        do {
            count = 1;          //re-state value of count after every loop
            
            //Prompt user for number entry
            System.out.print("Enter Phone Number: ");
            Scanner cellInput = new Scanner(System.in);

            try 
            {
                cellNumber = cellInput.nextLine();
                
                //Validate number entry , if entry is valid, catch block is skipped and loop ends
                Validator.checkCellNumber(cellNumber);
            } 
            catch (IllegalArgumentException e)
            {
                 //else if entry is invalid, display error message and set count back to 0, loop continues
                System.out.println(e.getMessage());
                count = 0;
            }

        } while (count == 0);       //As long as their's an invalid entry, loop will continue
           
        //After valid entries have been made, use entered data to build new address book entry object
        AddressBookEntry entry = new AddressBookEntry(name, email, cellNumber);
        
        //Object data is saved in the text file
        AddressBookIO.saveEntry(entry);
    }
    
    
    /*************************************************************
     *                                                           *
     *   displayMenu prints the client menu when program is ran  *
     *      Method was implemented to keep main method simple    *
     *                                                           *
     *************************************************************/
    public static void displayMenu()
    {
        System.out.println("1 - List entries");
        System.out.println("2 - Add entry");
        System.out.println("3 - Exit");
        
        System.out.print("\nEnter Menu Number: ");
    
    }

}

