/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seproject;

/**
 *
 * @author Kuvit
 */
import java.util.*;

/**
 *
 * @author micro
 */
public class UserAccount
        
{
  String firstName;
  String lastName;
  String email;
  String userName;
  
 
  
  public UserAccount(String firstName, String lastName, String email, String userName)
  {
      this.firstName= firstName;
      this.lastName = lastName;
      this.email = email;
      this.userName = userName;
  }

  public String getFirstName()
  {
    return this.firstName;
  }
  public String getLastName()
  {
    return this.lastName;
  }
  public String getEmail()
  {
    return this.email;
  }
  public String getUserName()
  {
    return this.userName;
  }
  

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }
  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }
  public void setEmail(String email)
  {
    this.email = email;
  }
  public void setUserName(String userName)
  {
    this.userName = userName;
  }

}