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
	int dateOfPayment;

    public Monthly(int amount, int charityID, int dateOfPayment) {
        super(amount, charityID);
        this.dateOfPayment= dateOfPayment;
    }
	
	public int getDateOfPayment()
	{
		return this.dateOfPayment;
	}
	
	public void setDateOfPayment(int dateOfPayment)
	{
		this.dateOfPayment = dateOfPayment;
	}
	
	
}