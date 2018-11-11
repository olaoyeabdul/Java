/**********************************************************
 *                                                        *
 *  CSCI 470/502        Assignment 7           Fall 2018  *
 *                                                        *
 *  Developer(s):  Abdulsalam Olaoye                      *
 *                                                        *
 *                                                        *
 *  Section:  1                                           *
 *                                                        *
 *  Due Date/Time:  11/07/2018   11:59 PM                 *
 *                                                        *
 *  Purpose: A GUI calculator test program, runs a simple *
 *       JFrame and displays using constructor of subClass*
 **********************************************************/

package calculatortest;



import javax.swing.JFrame;


public class CalculatorTest 
{    
    public static void main(String[] args) 
    {
       CalculatorGUI calculator = new CalculatorGUI();      //Assign calculator class reference to object
       calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       calculator.setSize(200,200);      //Set size of frame
       calculator.setVisible(true);      //set the visibility of frame
       
    }
    
}
