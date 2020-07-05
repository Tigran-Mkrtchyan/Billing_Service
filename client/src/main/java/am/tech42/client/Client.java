package am.tech42.client;

import am.tech42.billingservice.BillingService;
import am.tech42.billingservice.CreditCard;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.net.MalformedURLException;

public class Client  {

	public static void main (String [] args){

		try{

		BillingService firstBank  = (BillingService) Naming.lookup("rmi://127.0.0.1/firstBank");
		
		CreditCard firstBankCard = firstBank.getCard("Jhon","Smith");
		firstBank.addMoney(firstBankCard ,1000);
		firstBank.subMoney(firstBankCard ,250);
		int balance = firstBank.getCardBalance(firstBankCard);
		System.out.println(balance);
		System.out.println(firstBankCard.getFirstName());
		System.out.println(firstBankCard.getLastName());
		System.out.println(firstBankCard.getCardNumber());
		
		}catch (NotBoundException e){
			e.printStackTrace();
			
		}
		catch (MalformedURLException e){
			e.printStackTrace();
			
		}
		catch (RemoteException e){
			e.printStackTrace();
			
		}

	}

}