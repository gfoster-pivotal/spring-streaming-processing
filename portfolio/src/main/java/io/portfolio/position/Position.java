package io.portfolio.position;

/**
 * Created by gfoster on 9/26/15.
 */
public class Position {
    private String name;
    private double portfolioValue;

    public Position(String name, double portfolioValue) {
        this.name = name;
        this.portfolioValue = portfolioValue;
    }

    public String getName() {
        return name;
    }

    public double getPortfolioValue() {
        return portfolioValue;
    }
}
