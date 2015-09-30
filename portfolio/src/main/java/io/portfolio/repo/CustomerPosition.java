package io.portfolio.repo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CustomerPosition implements Serializable {
	private static final long serialVersionUID = 1321571338473887988L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private int numShares;
	private String stockName;
	private double totalPositionValue;

	@ManyToOne(optional = false)
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public int getNumShares() {
		return numShares;
	}

	public double getTotalPositionValue() {
		return totalPositionValue;
	}

	public String getStockName() {
		return stockName;
	}

	public void setTotalPositionValue(double totalPositionValue) {
		this.totalPositionValue = totalPositionValue;
	}
}
