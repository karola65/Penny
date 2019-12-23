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
public class Donation{

	int amount;
	int charityID;

        public Donation(int amount, int charityID)
	{
		this.amount = amount;
		this.charityID = charityID;
	}
        
        

	
	
	public int getAmount()
	{
		return this.amount;
	}
	
	public int getCharityID()
	{
		return this.charityID;
	}
	
	public void setAmount(int amount)
	{
		this.amount = amount;
	}
	
	public void setCharity(int charityID)
	{
		this.charityID = charityID;
	}
	
	
	
}