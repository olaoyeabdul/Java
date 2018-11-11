/**********************************************************
 *                                                        *
 *  CSCI 470/502        Assignment 4            Fall 2018 *
 *                                                        *
 *  Class Name:  Destination                              *
 *                                                        *
 *  Developer(s):  Abdulsalam I Olaoye                    *
 *                                                        *
 *  Purpose: The class implements destination objects     *
 *   with attributes such as cityName, normalMiles  which *
 *   are used to save data received from client text file *
 *                                                        *
 **********************************************************/ 

package mileredemptionapp;


public class Destination 
{
    
    private String cityName;        //holds name of cities
    private int normalMiles;        // holds normal miles required to travel to a destination
    private int freqFlyerMiles;     // holds amount of miles needed to travel during off season by a frequent flyer
    private int upgradeMiles;       //Hold amount of miles needed to upgrade tickets to first class
    private int startMonth;         //Frequent flyer Offseason start month
    private int endMonth;           //Frequent flyer Offseason end month
    
     /**************************************************
     *                                                *
     * Constructor initializes the instance variables *
     *                                                *
     **************************************************/
    public Destination(String city, int mile, int freqFlyerMiles, int upgradeMiles, int startMonth, int endMonth)
    {
        
        this.cityName = city;
        this.normalMiles = mile;
        this.freqFlyerMiles = freqFlyerMiles;
        this.upgradeMiles = upgradeMiles;
        this.startMonth = startMonth;
        this.endMonth = endMonth;
         
    }
    
    
    /**********************************************************
     *                                                        *
     * getCityName returns private instance variable cityName * 
     *                                                        *
     * ********************************************************/
    public String getCityName()
    {
        return cityName;
    }
    
    /**********************************************************
     *                                                        *
     *   setCityName sets private instance variable cityName  * 
     *                                                        *
     * ********************************************************/
    public void setCityName(String city)
    {
        cityName = city;
    }
    
    
    /****************************************************************
     *                                                              *
     * getNormalMiles returns private instance variable normalMiles * 
     *                                                              *
     * **************************************************************/
    public int getNormalMiles()
    {
        return normalMiles;
    }
    
    /****************************************************************
     *                                                              *
     *   setNormalMiles sets private instance variable normalMiles  * 
     *                                                              *
     * **************************************************************/
    public void setNormalMiles(int mile)
    {
        normalMiles = mile;
    }
    
  
    /**********************************************************************
     *                                                                    *
     * getFreqFlyerMiles returns private instance variable FreqFlyerMiles * 
     *                                                                    *
     * ********************************************************************/
    public int getFreqFlyerMiles()  
    {
        return freqFlyerMiles;
    }
    
    
    /*******************************************************************
     *                                                                 *
     * setFreqFlyerMiles sets private instance variable FreqFlyerMiles * 
     *                                                                 *
     * *****************************************************************/
    public void setFreqFlyerMiles(int mile)
    {
        freqFlyerMiles = mile; 
    }
    
    
     /**********************************************************************
     *                                                                    *
     *   getUpgradeMiles returns private instance variable upgradeMiles   * 
     *                                                                    *
     * ********************************************************************/
    public int getUpgradeMiles()
    {
        return upgradeMiles;
    }
    
    
    /**********************************************************************
     *                                                                    *
     *    setUpgradeMiles sets private instance variable upgradeMiles     * 
     *                                                                    *
     * ********************************************************************/
    public void setUpgradeMiles(int mile)
    {
        upgradeMiles = mile;
    }
    
    
    /**********************************************************************
     *                                                                    *
     *      getStartMonth returns private instance variable startMonth    * 
     *                                                                    *
     * ********************************************************************/
    public int getStartMonth()
    {
        return startMonth;
    }
    
    
    /**********************************************************************
     *                                                                    *
     *       setStartMonth sets private instance variable startMonth      * 
     *                                                                    *
     * ********************************************************************/
    public void setStartMonth(int month)
    {
        startMonth = month;
    }
    
    
    /**********************************************************************
     *                                                                    *
     *      getEndMonth returns private instance variable endMonth        * 
     *                                                                    *
     * ********************************************************************/
    public int getEndMonth()
    {
        return endMonth;
    }
    
    
    /**********************************************************************
     *                                                                    *
     *        setEndMonth sets private instance variable endMonth         * 
     *                                                                    *
     * ********************************************************************/
    public void setEndMonth(int month)
    {
        endMonth = month;
    }
    

}
