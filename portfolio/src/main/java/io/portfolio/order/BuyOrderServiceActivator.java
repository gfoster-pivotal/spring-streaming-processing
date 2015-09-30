package io.portfolio.order;

import io.portfolio.repo.Customer;
import io.portfolio.repo.CustomerRepository;
import io.portfolio.repo.Stock;
import io.portfolio.repo.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by gfoster on 9/25/15.
 */
@Component
public class BuyOrderServiceActivator {
    private final CustomerRepository customerRepository;
    private final StockRepository stockRepository;

    @Autowired
    public BuyOrderServiceActivator(CustomerRepository customerRepository, StockRepository stockRepository) {
        this.customerRepository = customerRepository;
        this.stockRepository = stockRepository;
    }

    public BuyOrder processOrder(BuyOrder buyOrder) {
        long customerId = buyOrder.getCustomerId();
        Customer customer = customerRepository.findOne(customerId);

        Optional<Stock> stockOptional = stockRepository.findOneByName(buyOrder.getStock());
        Stock stock = stockOptional.get();
        double stockPrice = stock.getPrice();
        double customerCash = customer.getFreeCash() - buyOrder.getNumShares() * stockPrice;
        if(customerCash >= 0){
            customer.setFreeCash(customerCash);
            customerRepository.save(customer);
            return buyOrder;
        }

        return null;
    }
}