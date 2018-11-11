/**********************************************************
 *                                                        *
 *  CSCI 470/502        Assignment 5            Fall 2018 *
 *                                                        *
 *  Class Name:  AddressBookEntry                         *
 *                                                        *
 *  Developer(s):  Abdulsalam I Olaoye                    *
 *                                                        *
 *  Purpose: A basic address book class with instance     *
 *           variables and their get and set methods      *                                              *
 **********************************************************/ 
package addressbookentryapp;


public class AddressBookEntry {
    
    private String name;
    private String email;
    private String cellNumber;
    
    
    /**************************************************
     *                                                *
     * Constructor initializes the instance variables *
     *                                                *
     **************************************************/
    public AddressBookEntry(String name, String email, String cellNumber)
    {
        this.name = name;
        this.email = email;
        this.cellNumber = cellNumber;
    }
    
    
    /**********************************************************
     *                                                        *
     *      setName sets private instance variable Name       * 
     *                                                        *
     * ********************************************************/
    public void setName(String name)
    {
        this.name = name;
    }
    
    
    /**********************************************************
     *                                                        *
     *      getName returns private instance variable Name    * 
     *                                                        *
     * ********************************************************/
    public String getName()
    {
        return name;
    }
    
    
    /**********************************************************
     *                                                        *
     *      setEmail sets private instance variable email     * 
     *                                                        *
     * ********************************************************/
    public void setEmail(String email)
    {
         this.email = email;
    }
    
    
    
    /***********************************************************
     *                                                         *
     *      getEmail returns private instance variable email   * 
     *                                                         *
     * *********************************************************/
    public String getEmail()
    {
        return email;
    }
    
    
    /************************************************************
     *                                                          *
     * setCellNumber sets private instance variable cellNumber  * 
     *                                                          *
     * **********************************************************/
    public void setCellNumber(String cellNumber)
    {
        this.cellNumber = cellNumber;
    }
    
    
    
    /***************************************************************
     *                                                             *
     * getCellNumber returns private instance variable cellNumber  * 
     *                                                             *
     * *************************************************************/
    public String getCellNumber()
    {
        return cellNumber;
    }
    
}
