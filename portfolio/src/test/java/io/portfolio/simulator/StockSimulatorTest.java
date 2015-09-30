package io.portfolio.simulator;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.portfolio.repo.Stock;

import static org.junit.Assert.assertThat;

/**
 * Created by gfoster on 9/27/15.
 */
public class StockSimulatorTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getInitialStockPriceWithOneBetaAndEpsilon() {
        StockSimulator stockSimulator = new StockSimulator("test", 0, new double[]{1.0}, new double[]{1});
        Stock nextStockPrice = stockSimulator.getNextStockPrice();
        assertThat(nextStockPrice, CoreMatchers.is(1.1));
    }

    @Test
    public void getStockPriceWithTwoBetaAndEpsilon() {
        StockSimulator stockSimulator = new StockSimulator("test", 0, new double[]{1.0, 1.0}, new double[]{.5, .5});
        Stock nextStockPrice = stockSimulator.getNextStockPrice();
        assertThat(nextStockPrice, CoreMatchers.is(1.1));

        nextStockPrice = stockSimulator.getNextStockPrice();
//        assertThat(nextStockPrice, Matchers.closeTo(1.15, .1));
    }
}