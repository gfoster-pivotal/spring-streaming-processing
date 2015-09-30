package io.portfolio.order;

public interface OrderService {
	BuyOrder submitBuyOrder(String stock, int numShares, long customerId);

	SellOrder submitSellOrder(String stock, int numShares, long customerId);
}
