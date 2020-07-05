package am.tech42.billingservice;
import java.io.Serializable;

public class CreditCard implements Serializable{
	private String firstName;
	private String lastName;
	private int cardNumber;
	private int balance;

	public CreditCard(String firstName, String lastName,int cardNumber,int balance){
		this.firstName = firstName;
		this.lastName = lastName;
		this.cardNumber = cardNumber;
		this.balance = balance;
	}

	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public int getCardNumber(){
		return cardNumber;
	}
	public int  getBalance(){
		return balance;
	}
	public void setBalance(int balance){
		this.balance = balance;
	}


}