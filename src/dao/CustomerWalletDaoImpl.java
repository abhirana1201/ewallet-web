package dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



import entitites.CustomerWallet;
import exception.CustomerNotFoundException;

public class CustomerWalletDaoImpl implements CustomerWalletDao {
	  private Map<String, CustomerWallet> store = new HashMap<>();
	@Override
	public void addCustomer(CustomerWallet e) {
		store.put(e.getMobileNo(), e);
		}
	
	@Override
	public CustomerWallet transferMoney(CustomerWallet sender,CustomerWallet receiver, double amt) {
		if (sender.getBalance() >= amt) {
			receiver.addBalance(amt);
			sender.addBalance(-amt);
		}
		return receiver;
	}
		public CustomerWalletDaoImpl() {
	        CustomerWallet user1 = new CustomerWallet("satya", "1234");
	        store.put("satya", user1);
	        CustomerWallet user2 = new CustomerWallet("pranav", "678");
	        store.put("pranav", user2);

		}

	@Override
	public CustomerWallet findByMobileNo(String mobileNo) {
		 CustomerWallet e = store.get(mobileNo);
	        if (e == null) {
	            throw new CustomerNotFoundException("customer not found for id=" + mobileNo);
	        }
	        return e;
	}
	@Override
	 public boolean credentialsCorrect(String mobileNo, String password) {
	        CustomerWallet user = store.get(mobileNo);
	        if (user == null) {
	            return false;
	        }
	        return user.getPassword().equals(password);
	    }

	@Override
	public Set<CustomerWallet> allCustomer() {
		Collection<CustomerWallet> cust = store.values();
        Set<CustomerWallet> custSet = new HashSet<>(cust);
        return custSet;
	}
	
	
	}

