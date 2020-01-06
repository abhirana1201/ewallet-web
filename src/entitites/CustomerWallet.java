package entitites;

public class CustomerWallet {
	private String mobileNo;
	private String name;
	private double balance;
 private String password;
	public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

	public CustomerWallet() {

	}

	public String getMobileNo() {
		return mobileNo;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addBalance(double balance) {
		this.balance += balance;
	}

	

	public CustomerWallet(String mobileNo, String name, double balance) {
		this.mobileNo = mobileNo;
		this.name = name;
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		return mobileNo.hashCode();
	}

	@Override
	public String toString() {
		return mobileNo + " " + name + " " + balance;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			{
			return true;
			}
		if (obj == null || !(obj instanceof CustomerWallet)) {
			return false;
		}
		CustomerWallet e = (CustomerWallet) obj;
		return e.mobileNo.equals(this.mobileNo) ;

	}

	

}