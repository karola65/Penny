/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penny;

/**
 *
 * @author micro
 */
public class Monthly extends Donation{
	String dateOfPayment;
        String charityName;

    public Monthly(int amount, int charityID, String dateOfPayment,  String charityName) {
       
         super(amount, charityID);
        this.dateOfPayment= dateOfPayment;
        this.charityName = charityName;
    }

    public Monthly() 
    {
        
        
        this.dateOfPayment= dateOfPayment;
        this.charityName = charityName;
    }
	
	public String getDateOfPayment()
	{
		return this.dateOfPayment;
	}
	
	public void setDateOfPayment(String dateOfPayment)
	{
		this.dateOfPayment = dateOfPayment;
	}
        public String getCharityName()
        {
            return this.charityName;
        }
        public void setCharityName(String charityName)
        {
            this.charityName =charityName;
        }
	
}