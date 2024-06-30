package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "REVIEWS")
public class Review {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Customer_ID", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "Car_ID", nullable = false)
    private Car car;

    @Column(name = "Review_Star", nullable = false)
    private Integer reviewStar;

    @Column(name = "Comment", length = 500)
    private String comment;

	public Review(Customer customer, Car car, Integer reviewStar, String comment) {
		super();
		this.customer = customer;
		this.car = car;
		this.reviewStar = reviewStar;
		this.comment = comment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Integer getReviewStar() {
		return reviewStar;
	}

	public void setReviewStar(Integer reviewStar) {
		this.reviewStar = reviewStar;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Review [customer=" + customer + ", car=" + car + ", reviewStar=" + reviewStar + ", comment=" + comment
				+ "]";
	}
    
    

}
