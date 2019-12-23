/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penny;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
/**
 *
 * @author micro
 */
  public class CharityList {

	private static CharityList instance;
        private ArrayList<Charity> charities = new ArrayList<>();
        
        
	

        CharityList() throws ClassNotFoundException {
         
	}

	public static CharityList getInstance() throws ClassNotFoundException {
            
              
      
            
             if(instance == null)
            {
                instance = new CharityList ();
                 
                return instance;
            }
            else{
                 
                 
            return instance;}
		
	}
	
        public ArrayList<Charity> getCharities(){
            return this.charities;
        }
        
        public void updateCharity(Charity charityOld, Charity charityNew)
        {
            
            charityOld.setLocation(charityNew.getLocation().equals(null)? charityOld.getLocation() : charityNew.getLocation());
            charityOld.setKeyword(charityNew.getKeyword().equals(null)? charityOld.getKeyword() : charityNew.getKeyword());
            charityOld.setPurpose(charityNew.getPurpose().equals(null)? charityOld.getPurpose() : charityNew.getPurpose());
            charityOld.setName(charityNew.getName().equals(null)? charityOld.getName() : charityNew.getName());
            charityOld.setDescription(charityNew.getDescription().equals(null)? charityOld.getDescription() : charityNew.getDescription());
        }
	
        
        public void deleteCharity(Charity charity) {
            
            charities.remove(charity);
		
	}
	
	public ArrayList<Charity> findCharityByLocation(String location) {
           
            
            ArrayList<Charity> foundByLocation = new ArrayList<>();
            /*
            List<Charity> foundByLocation2 = charities.stream()
                    .filter(charity -> charity.location.equals(location))
                    .collect(Collectors.toList());
            */
            for (int i =0; i < charities.size(); i ++)
                
            { 
                if(location.equals(charities.get(i).location))
                {
                    foundByLocation.add(charities.get(i));
                }
            }

            return foundByLocation;
	}

	public ArrayList<Charity> findCharityByKeyword(String keyword) {
            
           ArrayList<Charity> foundByKeyword = new ArrayList<>();
            
            
            for (int i =0; i < charities.size(); i ++)
                
            { 
                if(keyword.equals(charities.get(i).keyword))
                {
                    foundByKeyword.add(charities.get(i));
                }
            }
            return foundByKeyword;
	}

	
	public ArrayList<Charity> findCharityByName(String name) {
            
              
            ArrayList<Charity> foundByName = new ArrayList<>();
            
            
            for (int i =0; i < charities.size(); i ++)
                
            { 
                if(name.equals(charities.get(i).name))
                {
                    foundByName.add(charities.get(i));
                }
            }
            return foundByName;
	}

	
	public ArrayList<Charity> findCharityByPurpose(String purpose) {
            
               
            ArrayList<Charity> foundByPurpose = new ArrayList<>();
          
            for (int i =0; i < charities.size(); i ++)
                
            { 
                if(purpose.equals(charities.get(i).purpose))
                {
                    foundByPurpose.add(charities.get(i));
                }
            }
            return foundByPurpose;
	}

	
	public ArrayList<Charity> findCharityByCharityID(String charityID) {
            
             ArrayList<Charity> foundByCharityID = new ArrayList<>();
            for (int i =0; i < charities.size(); i ++)
                
            { 
                if(charityID.equals(charities.get(i).location))
                {
                    foundByCharityID.add(charities.get(i));
                }
            }
            return foundByCharityID;
		
	}

	public void addCharity(Charity charity) {
            
                charities.add(charity);
                
                
		}
        
         public ArrayList<Charity> getAllCharities() throws ClassNotFoundException, SQLException {
             
             charities.clear();
    
    Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/penny", "K","k");
    Statement query = conn.createStatement();    
      

   try {
        String sql = "SELECT * FROM CHARITY";

        ResultSet rs = query.executeQuery(sql);
        while (rs.next()) 
        {
            Charity charity = new Charity();

            charity.setName(rs.getString("NAME"));
            charity.setLocation(rs.getString("LOCATION"));
            charity.setKeyword(rs.getString("KEYWORD"));
            charity.setPurpose(rs.getString("PURPOSE"));
            charity.setDescription(rs.getString("DESCRIPTION"));
            charity.setCharityID(rs.getInt("CHARITYID"));
            charity.setPath(rs.getString("PATH"));

            charities.add(charity);
                
        }
        

    } catch (Exception e) {
        System.out.println("getAllCharities()");
        e.printStackTrace();
    }

  
return charities;

         }
	
}  

