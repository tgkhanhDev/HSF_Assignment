package pojos;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "ACCOUNTS")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AccountID")
	private int accountID;

	@Column(name = "AccountName")
	private String accountName;

	@Column(name = "Role")
	private String role;

	@OneToOne(cascade = javax.persistence.CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "AccountID")
	private Customer customer;

	

	public Account(int accountID, String accountName, String role) {
		super();
		this.accountID = accountID;
		this.accountName = accountName;
		this.role = role;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", accountName=" + accountName + ", role=" + role + ", customer="
				+ customer + "]";
	}

}
