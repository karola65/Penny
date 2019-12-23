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
public class Admin extends User {

	private static Admin admin = null;
        
   
        
       
	private Admin() {
        super();
    }
        
       

	public static Admin getInstance() {
            if(admin == null)
            {
                admin = new Admin ();
                return admin;
            }
            else{
            return admin;}
		
	}

   

        
}
