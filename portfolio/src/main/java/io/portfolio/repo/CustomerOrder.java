package io.portfolio.repo;

import javax.persistence.*;

/**
 * Created by gfoster on 9/26/15.
 */
@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int numShares;
    private String stockName;
    private double stockprice;

    @Enumerated(EnumType.STRING)
    private OrderType orderType;

	@ManyToOne(optional = false)
    private Customer customer;
}
