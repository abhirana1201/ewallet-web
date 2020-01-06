package service;

import java.util.Set;

import com.mycompany.app.AppUser;

import dao.CustomerWalletDao;
import entitites.CustomerWallet;
import exception.IncorrectMobileNoException;

public class CustomerWalletServiceImpl implements CustomerWalletService {
	private CustomerWalletDao dao;

	public CustomerWalletServiceImpl(CustomerWalletDao dao) {
		this.dao = dao;
	}

	@Override
	public void addCustomer(CustomerWallet e) {
		dao.addCustomer(e);
	}

	@Override
	public CustomerWallet findByMobileNo(String mobileNo) {
		if (mobileNo == null) {
			throw new IncorrectMobileNoException("id is incorrect");
		}
		CustomerWallet e = dao.findByMobileNo(mobileNo);
		return e;
	}
	
	  public CustomerWallet getUserByUsername(String mobileNo) {
	        CustomerWallet user = dao.getUserByUsername(mobileNo);
	        return user;
	    }

	@Override
	public Set<CustomerWallet> allCustomer() {
		Set<CustomerWallet> cust = dao.allCustomer();
		return cust;

	}
	
	 @Override
	    public boolean credentialsCorrect(String mobileNo, String password) {
	        boolean correct = dao.credentialsCorrect(mobileNo, password);
	        return correct;
	    }

	@Override
	public void transferMoney(CustomerWallet sender, CustomerWallet receiver, double amt) {
		dao.transferMoney(sender, receiver, amt);
	}

}