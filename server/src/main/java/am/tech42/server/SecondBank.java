package am.tech42.server;

import am.tech42.billingservice.BillingService;
import am.tech42.billingservice.CreditCard;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SecondBank extends UnicastRemoteObject implements BillingService {
	Map <Integer,CreditCard> cards ;

	public SecondBank() throws RemoteException {
		cards = new HashMap<>();
	}

	public CreditCard getCard(String firstName, String lastName) throws RemoteException{
		Integer cardNumber = generateCardNumber();
		while (cards.get(cardNumber) != null) {
			cardNumber = generateCardNumber();
		}
		CreditCard newCard = new CreditCard(firstName,lastName, cardNumber,0);
		cards.put(cardNumber, newCard);
		return newCard;
	}
	public  void addMoney(CreditCard clientCard, int money) throws RemoteException{
		CreditCard card = cards.get(clientCard.getCardNumber());
			card.setBalance(card.getBalance() + money);
			System.out.println(card.getBalance());
		}
		

	public void subMoney(CreditCard clientCard, int money) throws RemoteException{
		CreditCard card = cards.get(clientCard.getCardNumber());
		card.setBalance(card.getBalance() - money);
		System.out.println(card.getBalance());
	}

	public int  getCardBalance(CreditCard clientCard) throws RemoteException{
		CreditCard card = cards.get(clientCard.getCardNumber());
		return card.getBalance();
	}

	private int generateCardNumber() {
		int number =new Random().nextInt(10000);
		int number2 =new Random().nextInt(10000);
		while (number <1000){
			number = number * 10;
		}
		int result = number + number2*10000 ;
		return result;
	}


	
}