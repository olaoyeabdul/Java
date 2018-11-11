
package usmoneydemo;


public class USMoney 
{
    
    private int dollars; //Instance variable to hold dollars value
    private int cents;      //Instance variable to hold cents value
    
     /**************************************************
     *                                                *
     * Constructor initializes the instance variables *
     *                                                *
     **************************************************/
    public USMoney(int dolls, int cent)
    {
        dollars = dolls;
        
        if((cent >= 0)&&(cent <= 99))       //conditional statement to verify that cent arg isn't higher and lower than desired value
        {
            cents = cent;
        }
        else if (cent > 99)     //if it is, we balance the cent to not go above 99 
        {
            int dollas = cent/100;
            int cnt = cent % 100;
            
            cents = cnt;
            setDollars(getDollars() + dollas);
        }
        else{
            cents = 0;      //Negative arg will be defaulted to 0
        }
    }
    
    /*****************************************************************
     *                                                               *
     * getDollars returns value of private instance variable dollars * 
     *                                                               *
     * ***************************************************************/
    public int getDollars()
    {
        return dollars;
    }
    
    /********************************************************************
     *                                                                  *
     * setDollars which sets value of private instance variable dollars * 
     *                                                                  *
     * ******************************************************************/
    public void setDollars(int dolls)
    {
        dollars = dolls;
    }
    
    /*****************************************************************
     *                                                               *
     * getCents returns value of private instance variable cents     * 
     *                                                               *
     * ***************************************************************/
    public int getCents()
    {
        return cents;
    }
    
    /*****************************************************************
     *                                                               *
     * setCents ensure value of private instance variable cents does *
     *  does not exceed the limit of 99, whatever remains is sent to *
     *                  the dollars instance variable                *
     *                                                               *
     * ***************************************************************/
    public void setCents(int cent)
    {
        
        if((cent >= 0)&&(cent <= 99))   //conditional statement to verify that cent arg isn't higher and lower than desired value
        {
            cents = cent;
        }
        else if (cent > 99)         //if it is, we balance the cent to not go above 99 
        {
            int dolls = cent/100;
            int cnt = cent % 100;
            
            cents = cnt;
            setDollars(getDollars() + dolls);
        }
        else{
            cents = 0;                  //Negative arg will be defaulted to 0
        }
    }
    
    /***************************************************************
    *                                                              *
    * plus() is used to return a new USMoney object which contains *
    *  the total of the object calling it and the argument object  *
    *                                                              *
    ****************************************************************/
    public USMoney plus(USMoney obj)
    {
        int dolls = 0;          //Variables to hold dolls value, which later serves as arg 
        int cent = 0;           //Variable to store cent value, which later serves as arg 
        
        dolls = this.getDollars() + obj.getDollars();
        cent = this.getCents() + obj.getCents();
          
        USMoney money = new USMoney(dolls,cent);        //Return object
        
        return money;
    }
}
