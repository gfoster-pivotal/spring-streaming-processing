package io.portfolio.repo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * Created by gfoster on 9/25/15.
 */
@Entity
public class Customer implements Serializable {
	private static final long serialVersionUID = 283064336863609054L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private double freeCash;

	@JoinColumn
	@OneToMany
	private List<CustomerOrder> customerOrders;

	@JoinColumn
	@OneToMany
	private List<CustomerPosition> customerPositions;

	public Customer() {
	}

	public Customer(String name, double freeCash) {
		this.name = name;
		this.freeCash = freeCash;
	}

	public String getName() {
		return name;
	}

	public double getFreeCash() {
		return freeCash;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFreeCash(double freeCash) {
		this.freeCash = freeCash;
	}

	public List<CustomerPosition> getCustomerPositions() {
		return customerPositions;
	}
}
