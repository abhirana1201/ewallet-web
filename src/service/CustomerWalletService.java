package service;

import java.util.Set;

import entitites.CustomerWallet;

public interface CustomerWalletService {
		
	    void addCustomer(CustomerWallet e);

	    CustomerWallet findByMobileNo(String mobileNo);
	    
	    void transferMoney(CustomerWallet sender,CustomerWallet receiver, double amt);
	    boolean credentialsCorrect(String mobileNo, String password);

	    Set<CustomerWallet> allCustomer();
	}
