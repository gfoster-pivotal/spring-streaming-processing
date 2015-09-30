package io.portfolio.order;

/**
 * Created by gfoster on 9/25/15.
 */
public class BuyOrder {
    private String stock;
    private int numShares;
    private long customerId;

    public BuyOrder(String stock, int numShares, long customerId) {
        this.stock = stock;
        this.numShares = numShares;
        this.customerId=customerId;
    }

    public String getStock() {
        return stock;
    }

    public int getNumShares() {
        return numShares;
    }

    public long getCustomerId() {
        return customerId;
    }
}
