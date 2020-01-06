package ui;

import dao.CustomerWalletDaoImpl;
import entitites.CustomerWallet;
import service.CustomerWalletService;
import service.CustomerWalletServiceImpl;


import java.util.Collection;
import java.util.Set;

public class CustomerWalletMain {
	  private CustomerWalletService service = new CustomerWalletServiceImpl(new CustomerWalletDaoImpl());

	  public static void main(String[] args) {
	        CustomerWalletMain cust = new CustomerWalletMain();
	        cust.run();
	    }
	  public void run() {
	        try {
	        	CustomerWallet c1 = new CustomerWallet("9874538976","abhinav",500);
	    		CustomerWallet c2 = new CustomerWallet("9652876529","ram",300);
	    		c1.addBalance(500);
	    		c2.addBalance(1000);
	            service.addCustomer(c1);
	            service.addCustomer(c2);
	            CustomerWallet fetched1 = service.findByMobileNo("9652876529");
	            CustomerWallet fetched2 = service.findByMobileNo("9874538976");
	            System.out.println("fetched details: "+fetched1.getName());
	            System.out.println("fetched details: "+fetched2.getName());
	            System.out.println("********printing all employees after transactions****");
	            Set<CustomerWallet> customers = service.allCustomer();
	            print(customers);
	            service.transferMoney(c1, c2, 400);
	    		print(customers);
	        }catch (Throwable e){
	            e.printStackTrace();
	            System.out.println("something went wrong");
	        }
	    }
	  void print(Collection<CustomerWallet>customers){
		  System.out.println("Customer Wallet Details");
	        for (CustomerWallet c:customers){
	            System.out.println(c.getName()+" "+c.getBalance()+" "+c.getMobileNo());
	        }
	    }
}