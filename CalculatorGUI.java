/************************************************************
 *                                                          *
 *   CSCI 470/502        Assignment 7            Fall 2018  *
 *                                                          *
 *   Class Name:  CalculatorGUI                             *
 *                                                          *
 *   Developer(s):  Abdulsalam I Olaoye                     *
 *                                                          *
 *  Purpose: A basic GUI class that implements components   *
 *on a calculator and places them on JFrame using FlowLayout*
 ************************************************************/ 

package calculatortest;


import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;


public class CalculatorGUI extends JFrame
{
    private final JTextField entryField;
    private final JButton button1;
    private final JButton button2;
    private final JButton button3;
    private final JButton button4;
    private final JButton button5;
    private final JButton button6;
    private final JButton button7;
    private final JButton button8;
    private final JButton button9;
    private final JButton buttonZero;
    private final JButton buttonPlus;
    private final JButton buttonMinus;
    private final JButton buttonTimes;
    private final JButton buttonDivide;
    private final JButton buttonDot;
    private final JButton buttonEquals;
    
    /************************************************************
    * Constructor which instantiates all instance variables and *
    * assigns them in specific order of a calculator design     *
    *               used in the GUI class                       *
    ************************************************************/
    public CalculatorGUI()
    {
        super("Calculator");        //Set the super class constructor, with the title string
        
        setLayout(new FlowLayout());        //Frame main Layout
        
        Font font1 = new Font("Verdana", Font.PLAIN, 11);       //Font used for TextField
        
        //Calculatr data entryField initialised with 15 columns and a font, added to the fram right away
        entryField = new JTextField(15);
        entryField.setFont(font1);
        add(entryField);
        
        
        //Initialisation of buttons used on the calculator and their string labels
        button1 = new JButton("1");    
       
        button2 = new JButton("2"); 
        
        button3 = new JButton("3");
        
        button4 = new JButton("4");
        
        button5 = new JButton("5");
        
        button6 = new JButton("6");
        
        button7 = new JButton("7");
        
        button8 = new JButton("8");
        
        button9 = new JButton("9");
        
        buttonZero = new JButton("0");
        
        buttonPlus = new JButton("+");
        
        buttonMinus = new JButton("-");
        
        buttonTimes = new JButton("*");
        
        buttonDivide = new JButton("/");
        
        buttonDot = new JButton(".");
        
        buttonEquals = new JButton("=");
        
        
        //Each button added to the frame in the order they will appear 
        add(button7);
        add(button8);
        add(button9);
        add(buttonDivide);
         
        add(button4);
        add(button5);
        add(button6);
        add(buttonTimes);
        
        add(button1);
        add(button2);
        add(button3);
        add(buttonMinus);
        
        add(buttonZero);
        add(buttonDot);
        add(buttonEquals);
        add(buttonPlus);
        
        
        //object used to handle events gets initialised and added to each component
        CalculatorHandler handler = new CalculatorHandler();
      
        entryField.addActionListener(handler);
        button1.addActionListener(handler);
        button2.addActionListener(handler);
        button3.addActionListener(handler);
        button4.addActionListener(handler);
        button5.addActionListener(handler);
        button6.addActionListener(handler);
        button7.addActionListener(handler);
        button8.addActionListener(handler);
        button9.addActionListener(handler);
        buttonZero.addActionListener(handler);
        buttonPlus.addActionListener(handler);
        buttonMinus.addActionListener(handler);
        buttonTimes.addActionListener(handler);
        buttonDivide.addActionListener(handler);
        buttonDot.addActionListener(handler);
        buttonEquals.addActionListener(handler);
             
    }
    
    //CalulatorHandler class implements ActionListener interface
    public class CalculatorHandler implements ActionListener 
    {

        
        /********************************************************************
        * ALl components are checked to see if they are source of actions   *
        * the right component will be displayed with the label it holds or  *
        *                       String Value it holds                       *                                             
        *********************************************************************/
        @Override
        public void actionPerformed(ActionEvent event)
        {
            String str = "";        //String used in building event response
            
            
            //Each if statement checks for events and uses the event source i.e component
             //To assign a string constructed in the if statement body to the JOptionPane
            if(event.getSource() == entryField)
            {
                str = String.format("entryField: %s", event.getActionCommand());
            }
            else if(event.getSource() == button1)
            {
                str = String.format("button1: %s", event.getActionCommand());
            }
             else if(event.getSource() == button2)
            {
                str = String.format("button2: %s", event.getActionCommand());
            }
             else if(event.getSource() == button3)
            {
                str = String.format("button3: %s", event.getActionCommand());
            }
             else if(event.getSource() == button4)
            {
                str = String.format("button4: %s", event.getActionCommand());
            }
             else if(event.getSource() == button5)
            {
                str = String.format("button5: %s", event.getActionCommand());
            }
             else if(event.getSource() == button6)
            {
                str = String.format("button6: %s", event.getActionCommand());
            }
             else if(event.getSource() == button7)
            {
                str = String.format("button7: %s", event.getActionCommand());
            }
             else if(event.getSource() == button8)
            {
                str = String.format("button8: %s", event.getActionCommand());
            }
             else if(event.getSource() == button9)
            {
                str = String.format("button9: %s", event.getActionCommand());
            }
             else if(event.getSource() == buttonZero)
            {
                str = String.format("buttonZero: %s", event.getActionCommand());
            }
             else if(event.getSource() == buttonPlus)
            {
                str = String.format("buttonPlus: %s", event.getActionCommand());
            }
             else if(event.getSource() == buttonTimes)
            {
                str = String.format("buttonTimes: %s", event.getActionCommand());
            }
             else if(event.getSource() == buttonMinus)
            {
                str = String.format("buttonMinus: %s", event.getActionCommand());
            }
             else if(event.getSource() == buttonDivide)
            {
                str = String.format("buttonDivide: %s", event.getActionCommand());
            }
             else if(event.getSource() == buttonDot)
            {
                str = String.format("buttonDot: %s", event.getActionCommand());
            }
             else if(event.getSource() == buttonEquals)
            {
                str = String.format("buttonEquals: %s", event.getActionCommand());
            }
            
            JOptionPane.showMessageDialog(null, str);   //Displays event message whenever applicable
        }
    }

}
