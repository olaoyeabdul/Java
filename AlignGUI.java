/**********************************************************
 *                                                        *
 *  CSCI 470/502        Assignment 7            Fall 2018 *
 *                                                        *
 *  Class Name:  AlignGUI                                 *
 *                                                        *
 *  Developer(s):  Abdulsalam I Olaoye                    *
 *                                                        *
 *  Purpose: A basic GUI class that implements components *
 *      Aligns them and add them to panels on GridBagLayout*
 **********************************************************/ 

package aligntest;


import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JPanel;




public class AlignGUI extends JFrame
{
    private final JTextField textFieldX;    
    private final JTextField textFieldY;
    private final JButton buttonTop;
    private final JButton buttonCenter;
    private final JButton buttonBottom;
    private final JCheckBox checkSnap;      //Snap to Grid checkBox
    private final JCheckBox checkShow;      //Show grid checkBox
    private final JLabel labelX;
    private final JLabel labelY;
    private final JPanel panel;         //Panel used to hold left aligned components
    private final JPanel panel2;        //Panel used to hold center components
    private final JPanel panel3;        //Panel used to hold right aligned components
    private final GridBagConstraints gbc;           //Constraints for panel components
    private final GridBagConstraints gbc2;          //Constraints for panel2 components
    private final GridBagConstraints gbc3;          //Constraints for panel3 components
     
    
    /************************************************************
    * Constructor which instantiates all instance variables and *
    * assigns them to specific panels used in designing this    *
    *                           GUI class                       *
    ************************************************************/
    
    public AlignGUI()
    {
        super("Align");         //Set the super class constructor, with the title string
        setLayout(new FlowLayout());            //Frame main Layout
        
        //Panel instatiated with GridBagLayout
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
       
         //Panel2 instatiated with GridBagLayout
        panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        
         //Panel3 instatiated with GridBagLayout
        panel3 =new JPanel();
        panel3.setLayout(new GridBagLayout());
        
        //GridBagConstraints are instantiated, with  horizontal constarints
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc2 = new GridBagConstraints();
        gbc2.fill = GridBagConstraints.HORIZONTAL;
        
        gbc3 = new GridBagConstraints();
        gbc3.fill = GridBagConstraints.HORIZONTAL;
        
        
        //TextFields intantiated with 4 columns
        textFieldX = new JTextField(4);
        textFieldY = new JTextField(4);
        
        //Buttons instantiated with the String values they represent
        buttonTop = new JButton("Ok");
        buttonCenter = new JButton("Cancel");
        buttonBottom = new JButton("Help");
        
        //checkBoxes instatiated with their labels
        checkSnap = new JCheckBox("Snap to Grid");
        checkShow = new JCheckBox("Show Grid");
        
        //Labels for textFileds
        labelX = new JLabel("X:");
        labelY = new JLabel("Y:");
        
        //CheckBoxes are added to panel along with their GridBagConstraints
        gbc.gridx = 0;      //component position on x axis
        gbc.gridy = 0;      //component position on y axis
        panel.add(checkSnap,gbc);
        
        gbc.gridx = 0;      //component position on x axis
        gbc.gridy = 1;      //component position on y axis
        panel.add(checkShow,gbc);
        
        
        //Labels added to panel2 with their constraints
        gbc2.gridx = 0;     //component position on x axis
        gbc2.gridy = 0;     //component position on y axis
        gbc2.insets = new Insets(10,0,10,10);       //Used to set the spaces around components using this constraints
        panel2.add(labelX,gbc2);
        
        gbc2.gridx = 0;     //component position on x axis
        gbc2.gridy = 1;     //component position on y axis
        panel2.add(labelY,gbc2);
        
        //TextFileds added to panel2 using same constraints as Labels
        gbc2.gridx = 1;     //component position on x axis
        gbc2.gridy = 0;     //component position on y axis
        panel2.add(textFieldX,gbc2);
      
        gbc2.gridx = 1;     //component position on x axis
        gbc2.gridy = 1;     //component position on y axis
        panel2.add(textFieldY,gbc2);   
       
        
        //Buttons added to panel3 along with their constraints
        gbc3.gridx = 0;     //component position on x axis
        gbc3.gridy = 1;     //component position on y axis
        gbc3.insets = new Insets(10,10,0,5);     //Used to set the spaces around components using this constraints
        panel3.add(buttonTop,gbc3);

        gbc3.gridx = 0;     //component position on x axis
        gbc3.gridy = 2;     //component position on y axis
        panel3.add(buttonCenter,gbc3);

        gbc3.gridx = 0;
        gbc3.gridy = 3;
        panel3.add(buttonBottom,gbc3);
        
        
        //Each JPanel object is added to the JFrame
        add(panel);
        add(panel2);
        add(panel3);
        
        
        //object used to handle events gets initialised and added to each component
        AlignHandler handler = new AlignHandler();
        checkSnap.addActionListener(handler);
        checkShow.addActionListener(handler);
        textFieldX.addActionListener(handler);
        textFieldY.addActionListener(handler);
        buttonTop.addActionListener(handler);
        buttonCenter.addActionListener(handler);
        buttonBottom.addActionListener(handler);
        
           
    }
    
    //AlignHandler class implements ActionListener interface
    public class AlignHandler implements ActionListener
  {
        /********************************************************************
        * ALl components are checked to see if they are source of actions   *
        * the right component will be displayed with the label it holds or  *
        *                       String Value it holds                       *                                             
        *********************************************************************/
    @Override
    public void actionPerformed(ActionEvent event)
    {
      String string = "";       //String used in building event response
      
      //Each if statement checks for events and uses the event source i.e component
      //To assign a string constructed in the if statement body to the JOptionPane
      
      if(event.getSource() == checkSnap)
      {
          if(checkSnap.isSelected())
          {
            string = String.format("Snap to Grid: %s", "Checked");
          }
          else if(!checkSnap.isSelected())
          {
            string = String.format("Snap to Grid: %s", "Unchecked");
          }
      }
      else if (event.getSource() == checkShow)
      {
         if(checkShow.isSelected())
          {
            string = String.format("Show Grid: %s", "Checked");
          }
          else if(!checkShow.isSelected())
          {
            string = String.format("Show Grid: %s", "Unchecked");
          }
      }
      else if (event.getSource() == textFieldX)
      { 
          string = String.format("textFieldX: %s", event.getActionCommand());
      }
      else if (event.getSource() == textFieldY)
      {
          string = String.format("textFieldY: %s", event.getActionCommand());
      }
      else if (event.getSource() == buttonTop)
      { 
          string = String.format("Ok: %s", event.getActionCommand());
      }
      else if (event.getSource() == buttonCenter)
      { 
          string = String.format("Cancel: %s", event.getActionCommand());
      }
      else if (event.getSource() == buttonBottom)
      { 
          string = String.format("Help: %s", event.getActionCommand());
      }
      
      JOptionPane.showMessageDialog(null,string); //Displays event message whenever applicable
      
    }
  }
    
}
