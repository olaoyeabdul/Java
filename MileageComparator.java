/**********************************************************
 *                                                        *
 *  CSCI 470/502        Assignment 4            Fall 2018 *
 *                                                        *
 *  Class Name:  MileComparator                           *
 *                                                        *
 *  Developer(s):  Abdulsalam I Olaoye                    *
 *                                                        *
 *  Purpose:  The class overrides the compare method      *
 *      from Comparator class, this helps in sorting      *
 *                  Destination class objects             *
 **********************************************************/ 
package mileredemptionapp;
import java.util.Comparator;


public class MileageComparator implements Comparator<Destination> 
{
    /*******************************************************
     *                                                     *
     * @param d1 represents an object which is compared to *
     * @param d2, methods @return  object with  the greater*
     * of the 2 object amount of normalMile value          *
     *******************************************************/
    @Override
   public int compare(Destination d1, Destination d2) 
   {
      return (d2.getNormalMiles() - d1.getNormalMiles());
   }
   
  
}

