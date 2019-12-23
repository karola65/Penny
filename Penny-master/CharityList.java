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
  public class CharityList {

	private CharityList instance;
        private ArrayList<Charity> charities;

	

        private CharityList() {
		
	}

	public CharityList getInstance() {
            
             if(instance == null)
            {
                instance = new CharityList ();
                return instance;
            }
            else{
            return instance;}
		
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
                if(keyword.equals(charities.get(i).location))
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
                if(name.equals(charities.get(i).location))
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
                if(purpose.equals(charities.get(i).location))
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
        
        


	
}  

