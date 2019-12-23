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
  int cardNumber;
  int dateExpire;
  String type;
  int securityNumber;
  int balance;

  public String getNameOnCard()
  {
    return this.nameOnCard;
  }

  public void setNameOnCard(String nameOnCard)
  {
    this.nameOnCard = nameOnCard;
  }

  public int getCardNumber()
  {
    return this.cardNumber;
  }

  public void setCardNumber(int cardNumber)
  {
    this.cardNumber = cardNumber;
  }

  public int getExpireDate()
  {
    return this.dateExpire;
  }

  public void setExpireDate(int dateExpire)
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

  public int getBalance()
  {
    return this.balance;
  }

  public void setBalance(int balance)
  {
    this.balance = balance;
  }

  public void topUp(Card card, int balance)
  {
   
    card.setBalance(balance);
    
  }

}
