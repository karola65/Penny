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
public class Card {


  String nameOnCard;
  String cardNumber;
  String dateExpire;
  String type;
  int securityNumber;

  
  public Card()
  {
       this.nameOnCard=nameOnCard;
    this. cardNumber= cardNumber;
    this.dateExpire = dateExpire;
    this. type =type;
    this.securityNumber=securityNumber; 
  }
public Card(String nameOnCard, String cardNumber, String dateExpire, String type, int securityNumber)
{
    this.nameOnCard=nameOnCard;
    this. cardNumber= cardNumber;
    this.dateExpire = dateExpire;
    this. type =type;
    this.securityNumber=securityNumber;
    }
  public String getNameOnCard()
  {
    return this.nameOnCard;
  }

  public void setNameOnCard(String nameOnCard)
  {
    this.nameOnCard = nameOnCard;
  }

  public String getCardNumber()
  {
    return this.cardNumber;
  }

  public void setCardNumber(String cardNumber)
  {
    this.cardNumber = cardNumber;
  }

  public String getExpireDate()
  {
    return this.dateExpire;
  }

  public void setExpireDate(String dateExpire)
  {
    this.dateExpire = dateExpire;
  }

  public String getType()
  {
    return this.type;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public int getSecurityNumber()
  {
    return this.securityNumber;
  }

  public void setSecurityNumber(int securityNumber)
  {
    this.securityNumber = securityNumber;
  }

 

  

}
