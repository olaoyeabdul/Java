/**********************************************************
 *                                                        *
 *  CSCI 470/502        Assignment 4           Fall 2018  *
 *                                                        *
 *  Developer(s):  Abdulsalam Olaoye                      *
 *                                                        *
 *                                                        *
 *  Section:  1                                           *
 *                                                        *
 *  Due Date/Time:  10/5/2018   11:59 PM                  *
 *                                                        *
 *  Purpose: A ticket processing App which prompts client *
 *  for their appended miles and desired month of vacation*
 * and with the help of MileRedeemer and Destination class*
 * display available destinations, read from a file only  *
 *                      known by client                   *
 **********************************************************/
package mileredemptionapp;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class MileRedemptionApp
{
  public static void main(String[] args) throws IOException
  {
    String fileName;            //stores file name supplied by client
    int month;                  //stores month input from client
    int miles;                  //stores miles input from client
    
    
    //keyScan used to read client input
    Scanner keyScan = new Scanner(System.in);       
    
    //User is prompted for destination file name
    System.out.print("Please enter the name of the destination file: ");
    fileName = keyScan.nextLine();
    
    
    //entered file name is used to declare new scanner identifier to hold file
    Scanner file = new Scanner(new File(fileName));
    
    
    //new object of MileRedeemer class 
    MileRedeemer mileRedeemer = new MileRedeemer();
    
    
    //file is passed to readDestination
    mileRedeemer.readDestinations(file);
    
    
    //holds returned string array, will be used for menu display
    String [] ret = mileRedeemer.getCityNames();
    
    
    //method used to display welcome message and list of possible destination cities 
    displayCity(ret);
    
    //used to determine whether to stop do-while loop
    boolean continew ;
    
    
    
    //Menu Loop starts
    do{
        
        
        //Loop to print out menu pipes
        for (int i = 0; i < 65; i++) 
        {
            System.out.print("-");
        }
        
        //Prompt client for accumulated mile and assignt to miles variable
        System.out.print("\n\nPlease enter your client's accumulated Frequent Flyer Miles: ");

        miles = keyScan.nextInt();

        //Prompt user for month of departure and assign entry to month variable
        System.out.print("\nPlease enter your client's month of departure (1-12): ");
        
        month = keyScan.nextInt();

        //miles and month are passed to redeemMiles for client, returned tickets stored in redeem array
        String[] redeem = mileRedeemer.redeemMiles(miles, month);
        

        //Display returned tickets if redeem array isn't empty, else let client know there isn't any match
        if (redeem.length > 0)
        {
            System.out.print("\nYour client's Frequent Flyer Miles can be used to redeem the following tickets:");
            
            System.out.print("\n");
            
            for (int i = 0; i < redeem.length; i++) 
            {
                System.out.println(redeem[i]);    //Ticket string printed to screen
            }
        }
        else 
        {
            System.out.println("\n*** Your client has not accumulated enough Frequent Flyer Miles ***");
        }

        
        //Display client's left-over mileage 
        System.out.println("\n\nYour client's remaining Frequent Flyer Miles: " + mileRedeemer.getRemainingMiles());

        
        //used to hold client's response in menu, to determine if to halt program or not 
        String response;
        
        
        //Prompt client for continuation 
        System.out.print("Do you want to continue (y/n)? ");
      
        response = keyScan.next();
        
        
        //Check client's resonse to determine if to continue program or quit
        if(response.equals("yes")|| response.equals("Yes") || response.equals("y") || response .equals("Y"))
        {
            continew = true;        
        }
        else
        {
            continew = false;
        }
     
     
    }while(continew);           //Keep program going while client answers yes
    //Menu loop ends
    
    
    //Method displays end of program message to client
    displayEndMessage();
    
    
    //Close the scanner objects to avoid memory issues
    keyScan.close();
    file.close();
  }
  
  
 /************************************************************************
  *                     displayCity(String [] args)                      *
  * accepts string array containing cityNames, displays that and welcome *
  *      message on the menu, it's a helper function to reduce main ()   *
  *                             congestion                               *
  *                                                                      *
  ************************************************************************/
  public static void displayCity(String[] ret)
  {
      //loop prints display pipe
    for(int i = 0; i < 65; i++)
    {
        System.out.print("-");
    }
    
    System.out.println("\nWELCOME TO THE JAVA AIRLINES FREQUENT FLYER MILES REDEMPTION APP");
    
    //loop prints display pipe
    for(int i = 0; i < 65; i++)
    {
        System.out.print("-");
    }
    
    
    System.out.println("\n\nList of destination cities your client can travel to:\n");
    
    
    //Contents of Array looped through and displayed
    for(int i = 0; i < ret.length; i++)
     {
         System.out.println(ret[i]);
     }
  }
  
  
 /**********************************************************
  *                 displayEndMessage()                    *
  * Helper function used to display end of program message *
  *         This reduces main() code congestion            *
  *                                                        *
  **********************************************************/
  public static void displayEndMessage()
  {
      //loop prints display pipe
      for(int i = 0; i < 73; i++)
      {  
          System.out.print("-");
      }
      
      System.out.println("\nTHANK YOU FOR USING THE JAVA AIRLINES FREQUENT FLYER MILES REDEMPTION APP");
       
       
       //loop prints display pipe
      for(int i = 0; i < 73; i++)
      {
          System.out.print("-");
      }
        
      System.out.println("\n");
  }
  
}
