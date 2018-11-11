/************************************************************
 *                                                          *
 *  CSCI 470/502        Assignment 5            Fall 2018   *
 *                                                          *
 *  Class Name:  Validator                                  *
 *                                                          *
 *  Developer(s):  Abdulsalam I Olaoye                      *
 *                                                          *
 *  Purpose: A validator class with static methods which    *
 *are used to validate user entries in AddressBookEntry App *                                              *
 ************************************************************/ 
package addressbookentryapp;

public class Validator {
    
    
    /**********************************************************
     *                                                        *
     *   menuOptionl is used to validate menu option entry    *
     *              in the AddressBookEntryApp                *
     *                                                        *
     **********************************************************/
    public static void menuOption(int input)
    {
        //Client can only select options ranging from 1 to 3
        if(input > 3 || input < 1)
        {
            throw new IllegalArgumentException("\nSelect a valid option\n");
        }
    }
    
    
    /******************************************************
     *                                                    *
     *        checkName is used to validate name entry    *
     *                in the AddressBookEntryApp          *
     *                                                    *
     ******************************************************/
    public static void checkName(String name)
    {
        //Throw exception if name length is  0
        if(name.length() == 0)
        {
            throw new IllegalArgumentException("\nEnter a name\n");
        }
        
        //Remove all other acceptable characters from name string 
        name = name.replace("-","");
        name = name.replace(".","");
        name = name.replace(" ","");
        
        
        //Check if remaining characters are made up of letters, if they're not, throw an exception
        for(int i = 0; i < name.length(); i++)
        {
            if(!Character.isLetter(name.charAt(i)))
            {
                 throw new IllegalArgumentException("\nEnter a valid name\n");
            }
        }
    }
    
    
    /**********************************************************
     *                                                        *
     *   checkEmail is used to validate email address entry   * 
     *              in the AddressBookEntryApp                *
     *                                                        *
     **********************************************************/
    public static void checkEmail(String email)
    {
        //If email address entry is empty
        if(email.length() == 0)
        {
            throw new IllegalArgumentException("\nEnter an email address\n");
        }
        
        //If email addrsss starts with a @, this throws an exception
        if(email.startsWith("@"))
        {
             throw new IllegalArgumentException("\nEnter a valid email address\n");
        }
        
        int atPosition = email.indexOf("@");        //Checks the first occurence of @
        int multipleAt = email.lastIndexOf("@");    //returns different index position if there's another @ in email
        
        //if there's no @ or there are multiple @s
        if( (atPosition < 0) || atPosition != multipleAt)
        {
            throw new IllegalArgumentException("\nEnter a valid email address\n");
        }
        
        //Get starting position of first occurrence of ".com"
        int dotComPosition = email.indexOf(".com"); 
     //   int oriane = email.indexOf(".fr");
        
        //if .com doesn't exist 
        if(dotComPosition < 0)    
        {
            throw new IllegalArgumentException("\nEnter an email address that ends with \".com\"\n");
        }
        
        //Check if .com isn't the last 4 letters of email
        if (email.length() > (dotComPosition + 4)) 
        {
            throw new IllegalArgumentException("\nEnter an email address that ends with \".com\"\n");
        }
        
    }
    
    
    
    /**********************************************************
     *                                                        *
     *   checkCellNumber is used to validate cellNumber entry *
     *              in the AddressBookEntryApp                *
     *                                                        *
     **********************************************************/
    public static void checkCellNumber(String cellNumber)
    {
        //cellNumber shouldn't be less than 10 char, if it is, throw exception
        if(cellNumber.length() < 10)
        {
            throw new IllegalArgumentException("\nEnter a valid cell number\n");
        }
        

        //check if string only contains numbers, hyphen and brackets
       if(cellNumber.length() >= 10)
       {
           
          //remove all other acceptable characters from string
            cellNumber = cellNumber.replace("(", "");
               
            cellNumber = cellNumber.replace(")", "");
               
            cellNumber = cellNumber.replace(" ", "");
               
            cellNumber = cellNumber.replace("-","");
               
              
               
            // if after other accpetable xters, remaining xters are more than 10 in number, as regular phine number should be
            if(cellNumber.length() != 10 )
            {
                    throw new IllegalArgumentException("\nEnter a valid cell number\n");
            }
                
            //If there are only 10 characters left, loop through each character and check if they are digits, 
            //if a single xter isn't, throw an exception for invalid phone number
            if (cellNumber.length() == 10)
            {
                for(int i = 0; i < cellNumber.length(); i++)
                {
                    if(!Character.isDigit(cellNumber.charAt(i)))
                        {
                            throw new IllegalArgumentException("\nEnter a valid cell number\n");
                        }
                }
            }
 
       }
       
    }
    
}
