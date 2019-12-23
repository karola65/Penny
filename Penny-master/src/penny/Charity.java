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
public class Charity {
    
    String location;
    String name;
    String purpose;
    int charityID;
    String keyword;
    String description;
    String path;
    
    
    public String getLocation()
    {
        return this.location;
    }
    public String getName()
    {
        return this.name;
 
    }
    public String getPurpose()
    {
        return this.purpose;
        
    }
    public int getCharityID()
    {
        return this.charityID;
    
    }
    public String getKeyword()
    {
        return this.keyword;
        
    }
    public String getDescription()
          
    {
        return this.description;
    }
    
    public String getPath()
    {
        return this.path;
    }
    public void setLocation(String location)
    {
        this.location = location;
        
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setPurpose(String purpose)
    {
        this.purpose = purpose;
    }
   
     public void setKeyword(String keyword)
    {
        this.keyword = keyword;
    }
      public void setCharityID(int charityID)
    {
        this.charityID = charityID;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public void setPath (String path)
    {
        this.path=path;
    }
    public Charity(String location, String name, String purpose, int charityID, String keyword, String description, String path)
    {
        this.location = location;
        this.name = name;
        this.purpose = purpose;
        this.charityID = charityID;
        this.keyword = keyword;
        this.description = description;
        
        this.path = path;
    }
    public Charity()
    {
        this.location = location;
        this.name = name;
        this.purpose = purpose;
        this.charityID = charityID;
        this.keyword = keyword;
        this.description = description;
       
        this.path = path;
    // constarctors arth the top
    }
  
}



