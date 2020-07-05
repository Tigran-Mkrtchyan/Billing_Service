package am.tech42.billingservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BillingService extends Remote {
	CreditCard getCard(String firstName,String lastName) throws RemoteException;
	void addMoney(CreditCard card, int money) throws RemoteException;
	void subMoney(CreditCard card, int money) throws RemoteException;
	int  getCardBalance(CreditCard card) throws RemoteException;

}