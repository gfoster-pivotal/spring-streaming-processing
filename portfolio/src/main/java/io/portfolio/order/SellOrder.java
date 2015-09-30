package io.portfolio.order;

/**
 * Created by gfoster on 9/25/15.
 */
public class SellOrder {
    private String stock;
    private int numShares;

    public SellOrder(String stock, int numShares) {
        this.stock = stock;
        this.numShares = numShares;
    }

    public String getStock() {
        return stock;
    }

    public int getNumShares() {
        return numShares;
    }
}
