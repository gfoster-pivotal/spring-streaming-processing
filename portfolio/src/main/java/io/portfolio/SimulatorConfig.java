package io.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.portfolio.simulator.StockSimulator;

@Configuration
public class SimulatorConfig {
	@Bean
	public StockSimulator teslaStockSimulator() {
		double[] initialStockPrices = { 256.91, 263.12 };
		double[] previousStockPriceBetas = { .5, .5 };
		double alpha = 0;
		return new StockSimulator("tsla", alpha, initialStockPrices, previousStockPriceBetas);
	}

	@Bean
	public StockSimulator emcStockSimulator() {
		double[] initialStockPrices = { 23.78, 23.76 };
		double[] previousStockPriceBetas = { .5, .5 };
		double alpha = 0;
		return new StockSimulator("emc", alpha, initialStockPrices, previousStockPriceBetas);
	}
}
