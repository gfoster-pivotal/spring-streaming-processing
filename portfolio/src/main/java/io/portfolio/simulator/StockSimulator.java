package io.portfolio.simulator;

import java.util.Random;

import io.portfolio.repo.Stock;

/**
 * Created by gfoster on 9/27/15.
 */
public class StockSimulator {
	private String stockName;
	private double alpha;
	private double[] previousStockPriceBetas;
	private double[] previousStockPrices;
	private Random random = new Random();

	public StockSimulator(String stockName, double alpha, double[] initialStockPrices,
			double[] previousStockPriceBetas) {
		this.stockName = stockName;
		this.alpha = alpha;
		this.previousStockPriceBetas = previousStockPriceBetas;
		previousStockPrices = initialStockPrices;
	}

	public Stock getNextStockPrice() {
		double sum = 0.0;
		int length = previousStockPrices.length;
		for (int i = 0; i < length; i++) {
			sum = previousStockPriceBetas[i] * previousStockPrices[i] + sum;
		}

		double[] copy = new double[length];
		System.arraycopy(previousStockPrices, 0, copy, 1, length - 1);
		previousStockPrices = copy;
		double eplison = random.nextDouble();
		previousStockPrices[0] = Math.max(alpha + sum + eplison, 0);
		Stock stock = new Stock(stockName, previousStockPrices[0]);
		return stock;
	}

	public String getStockName() {
		return stockName;
	}
}
