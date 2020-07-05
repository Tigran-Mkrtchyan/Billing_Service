package am.tech42.server;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.AlreadyBoundException;

public class Server{
	public static void main (String [] args){

		try{
		Registry registry = LocateRegistry.createRegistry(1099);
		FirstBank billingservice = new FirstBank();
		SecondBank billingservice1 = new SecondBank();
		registry.bind ("firstBank", billingservice);
		registry.bind ("secondBank", billingservice1);
		}
		catch(RemoteException e){
			e.printStackTrace();
		}
		catch(AlreadyBoundException e){
			e.printStackTrace();
		}

	}
}