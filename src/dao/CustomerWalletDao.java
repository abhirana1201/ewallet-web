package dao;

import java.util.Set;

import entitites.CustomerWallet;

public interface CustomerWalletDao {
	
	    void addCustomer(CustomerWallet e);

	    CustomerWallet findByMobileNo(String mobileNo);
	    
	    CustomerWallet transferMoney(CustomerWallet sender,CustomerWallet receiver, double amt);
	    boolean credentialsCorrect(String mobileNo, String password);

	    Set<CustomerWallet> allCustomer();
	}
