package pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CustomerID")
	private int customerID;

	@Column(name = "CustomerName")
	private String customerName;

	@Column(name = "Mobile" , length = 10)
	private String mobile;

	@Column(name = "Birthdate")
	@Temporal(TemporalType.DATE)
	private Date birthday;

	@Column(name = "IdentityCard")
	private String identityCard;

	@Column(name = "LicenceNumber")
	private String licenceNumber;

	@Column(name = "LicenceDate")
	@Temporal(TemporalType.DATE)
	private Date licenceDate;

	@Column(name = "Email")
	private String email;

	@Column(name = "Password")
	private String password;

	@OneToOne(cascade = javax.persistence.CascadeType.ALL)
	@JoinColumn(name = "AccountID")
	private Account account;

	public Customer(String customerName, String mobile, Date birthday, String identityCard, String licenceNumber,
			Date licenceDate, String email, String password, Account account) {
		super();
		this.customerName = customerName;
		this.mobile = mobile;
		this.birthday = birthday;
		this.identityCard = identityCard;
		this.licenceNumber = licenceNumber;
		this.licenceDate = licenceDate;
		this.email = email;
		this.password = password;
		this.account = account;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	public Date getLicenceDate() {
		return licenceDate;
	}

	public void setLicenceDate(Date licenceDate) {
		this.licenceDate = licenceDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", mobile=" + mobile
				+ ", birthday=" + birthday + ", identityCard=" + identityCard + ", licenceNumber=" + licenceNumber
				+ ", licenceDate=" + licenceDate + ", email=" + email + ", password=" + password + ", account="
				+ account + "]";
	}

}
