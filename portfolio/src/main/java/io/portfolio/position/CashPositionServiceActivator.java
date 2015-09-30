package io.portfolio.position;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.portfolio.repo.Customer;
import io.portfolio.repo.CustomerPosition;
import io.portfolio.repo.CustomerPositionRepository;
import io.portfolio.repo.CustomerRepository;
import io.portfolio.repo.Stock;

@Component
public class CashPositionServiceActivator {
	private final CustomerPositionRepository customerPositionRepository;
	private final CustomerRepository customerRepository;

	@Autowired
	public CashPositionServiceActivator(CustomerPositionRepository customerPositionRepository, CustomerRepository customerRepository) {
		this.customerPositionRepository = customerPositionRepository;
		this.customerRepository = customerRepository;
	}

	@Transactional
	public Map<String, Double> calculateCashPositions(Stock stock) {
		List<CustomerPosition> customerPositions = customerPositionRepository.findAllByStockName(stock.getName()).stream().map(customerPosition -> {
			double totalPositionValue = customerPosition.getNumShares() * stock.getPrice();
			customerPosition.setTotalPositionValue(totalPositionValue);
			return customerPosition;
		}).collect(Collectors.toList());
		customerPositionRepository.save(customerPositions);

		Map<String, Double> collect = customerRepository.findAll().stream()
				.collect(Collectors.groupingBy(Customer::getName, Collectors.summingDouble(value -> value.getFreeCash() + value.getCustomerPositions().stream().mapToDouble(CustomerPosition::getTotalPositionValue).sum())));
		return collect;
	}
}
