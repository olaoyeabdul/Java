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
 *  Purpose:A GUI Align test program, runs a simple JFrame*
 *           and displays using constructor of subClass   *
 **********************************************************/

package aligntest;

import javax.swing.JFrame;

public class AlignTest {

    
    public static void main(String[] args) 
    {
        AlignGUI align = new AlignGUI();        //Assign align class reference to object
        align.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        align.setSize(300,160);         //Set size of frame
        align.setVisible(true);         //set the visibility of frame
        
    }
    
}
