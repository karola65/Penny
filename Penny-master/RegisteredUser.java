/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penny;

import java.util.*;

/**
 *
 * @author micro
 */
public class RegisteredUser extends User// attributes and constractors
{
     private ArrayList<Monthly> monthlyDonations;
     
    public RegisteredUser(String firstName, String lastName, String email, String userName, String password) {
        super(firstName, lastName, email, userName, password);
    }
  public void makeMonthlyDonation(int amount, int charityId, int dateOfPayment)
  { 
      Monthly donation = new Monthly(amount, charityId, dateOfPayment);
      monthlyDonations.add(donation);
  }
  
  public void makeDonation(int amount, int charityId)
  { 
      Donation donation = new Donation(amount, charityId);
      
      
  }

  public void cancelMonthlyDonation(Donation donation)
	{
		monthlyDonations.remove(donation);
	}
}
