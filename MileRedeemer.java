/**********************************************************
 *                                                        *
 *  CSCI 470/502        Assignment 4            Fall 2018 *
 *                                                        *
 *  Class Name:  MileRedeemer                             *
 *                                                        *
 *  Developer(s):  Abdulsalam I Olaoye                    *
 *                                                        *
 *  Purpose:  what the class represents and anything      *
 *            special that might be misunderstood         *
 *                                                        *
 **********************************************************/ 
package mileredemptionapp;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MileRedeemer 
{
    private ArrayList<Destination> destinationList = new ArrayList<>();     //To hold destinations and their components
    
    private int remainingMiles;         //To store remaining miles 
  
    
  /****************************************************************** 
   *                                                                *
   * readDestinations receives a scanner object parameter and uses  *
   * the Scanner object to read and parse the destination data into *
   *    an array of Destination objects, which are sorted in        *   
   *             descending order by normalMiles                    *
   *                                                                *
   ******************************************************************/
  public void readDestinations(Scanner fileScan) throws IOException
  {   
    while(fileScan.hasNext())
    {
       String record;       //Stores each line from file
      
       record = fileScan.nextLine();
     
       String[] rec = record.split(";");                    //rec[] stores split string for an entire line from the file
      
       String city = rec[0];                                //city stores city data
       int normalMiles = Integer.parseInt(rec[1]);          //miles stores the original normalMiles data
       int freqFlyerMiles = Integer.parseInt(rec[2]);       //stores the frequent flyer milage data 
       int upgradeMiles = Integer.parseInt(rec[3]);         //Stores the upgrade mile data
       String months = rec[4];                              //Stores the off season months which are yet to be split
       
       String[] spl = months.split("-");                     //spl[] stores split off season months  
       
       int startMonth = Integer.parseInt(spl[0]);            //off season start month
       int endMonth = Integer.parseInt(spl[1]);              //off season end month
       
       
       //Line parsed from file is used to create a Destination object
       Destination destination = new Destination(city,normalMiles,freqFlyerMiles,upgradeMiles,startMonth,endMonth);
       
       destinationList.add(destination);        //Object is added to ArrayList
      
    }
    
   Collections.sort(destinationList, new MileageComparator());       //Sort objects based on normalMiles 
  
  }
  

  /**********************************************************************
   *                                                                    *
   * getCityNames returns a list of possible destination cities parsed  *
   *        from file by looping through destination object array       *
   *                                                                    *
   **********************************************************************/
  public String[] getCityNames()
  {
     String[] ret = new String[destinationList.size()];     //Return array with same capacity as destinationList<> 
     
     //Loop through object cityNames and add each city to return array
     for(int i = 0; i < ret.length; i++)
     {
         ret[i] = destinationList.get(i).getCityName();
     }
     
     //Array is sorted in alphabetical order
     Arrays.sort(ret);
          
     return ret;
  }


  /**************************************************************************
   *                                                                        *
   * redeemMiles returns an array of String objects containing descriptions *
   *        of redeemed tickets to be printed out by the main program       *
   *                                                                        *
   **************************************************************************/  
  public String[] redeemMiles(int miles, int month)
  {
      ArrayList<String> destinationReturn = new ArrayList<>();      //will hold list of tickets to be returned
      
     
      
    
     
      setRemainingMiles(miles);         //Set available miles
      
      int count = 0;        //Counter variable
      
      //Loop to add tickets to the return array
      do {
          boolean offSeason = false;      //checks per object and toggle if its within month period
          
          //determine if month parameter value is within off season months 
          if((month >= destinationList.get(count).getStartMonth()) && (month <= destinationList.get(count).getEndMonth())  )
          {
              offSeason = true;     //toggle offseason
              
              //determine remainingMiles is enough to get a freqflyer ticket to the index city
              if( getRemainingMiles() >= destinationList.get(count).getFreqFlyerMiles())
              {
                  //deduct index Frequent flyer miles from remainingMiles  
                  setRemainingMiles(getRemainingMiles() - destinationList.get(count).getFreqFlyerMiles());
                  
                  //include the city as a possible destination by adding to the return arrayList
                  destinationReturn.add(destinationList.get(count).getCityName() + " in Economy Class");
              }

          }
          
          //else, if month isn't within off season of index city
          else if(offSeason == false)
          {
               //determine remainingMiles is enough to get a normal ticket to the index city
              if( getRemainingMiles() >= destinationList.get(count).getNormalMiles())
              {
                  //deduct index normalMiles from the remainingMiles
                  setRemainingMiles(getRemainingMiles() - destinationList.get(count).getNormalMiles());
                  
                  //include the city as a possible destination by adding to the return arrayList
                  destinationReturn.add(destinationList.get(count).getCityName() + " in Economy Class");
              }

          }
          count++;      //increment counter
          
         }while(count < destinationList.size() );   //loop through the destinationList
      
      
      //To upgrade Tickets to first Class
      for(int i = 0; i < destinationList.size(); i++)
      {
          //Loop through return array
          for(int k = 0; k < destinationReturn.size(); k++)
          {
              //If there's a ticket on return array and the ticket required miles upgradeMiles isn't higher than remainingMiles
              if((destinationReturn.get(k).startsWith(destinationList.get(i).getCityName()))  && 
                      (getRemainingMiles() >= destinationList.get(i).getUpgradeMiles())  )
              {
                  //Set the ticket to a first class
                 destinationReturn.set(k, destinationReturn.get(k).replaceFirst("Economy","First"));     
                  
                  //deduct index upgradeMiles from the remainingMiles
                 setRemainingMiles(getRemainingMiles() - destinationList.get(i).getUpgradeMiles());       
              }
          }
      }
      
      
      //Convert return ArrayList into an array of strings
      String[] ret = destinationReturn.toArray(new String[destinationReturn.size()]);  
      
      //Loop through the array 
      for(int i = 0; i < ret.length; i++)
      {
          ret[i] = "* A trip to " + ret[i];     //Concatenate string at the beginning of each string index
      }
     
      return ret;
      
  }
  
  
  /**********************************************************************
   *                                                                    *
   *  setRemainingMiles sets private instance variable remainingMiles   *
   *                                                                    *
   **********************************************************************/
  public void setRemainingMiles(int miles)
  {
      if(miles < 0)
      {
          remainingMiles = 0;
      }
      else
      {
          remainingMiles = miles;
      }
  }
  
  
  /**********************************************************************
   *                                                                    *
   * getRemainingMiles returns private instance variable remainingMiles *
   *                                                                    *
   **********************************************************************/
  public int getRemainingMiles()
  {
      return remainingMiles;
  }
}