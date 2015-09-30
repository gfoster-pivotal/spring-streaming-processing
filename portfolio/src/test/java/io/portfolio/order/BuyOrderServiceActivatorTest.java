package io.portfolio.order;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;

import io.portfolio.repo.Customer;
import io.portfolio.repo.CustomerRepository;
import io.portfolio.repo.Stock;
import io.portfolio.repo.StockRepository;

/**
 * Created by gfoster on 9/25/15.
 */
public class BuyOrderServiceActivatorTest {
	@InjectMocks
	private BuyOrderServiceActivator buyOrderServiceActivator;

	@Mock
	private CustomerRepository customerRepository;
	@Mock
	private StockRepository stockRepository;

	@Test
	public void buyOrderOfCustomerWithEnoughCashAndKnownStock() {
		Mockito.when(stockRepository.findOneByName(Matchers.anyString())).thenReturn(Optional.of(new Stock("TSLA", 10)));
		Mockito.when(customerRepository.findOne(Matchers.anyLong())).thenReturn(new Customer("Test user", 500));

		BuyOrder optional = buyOrderServiceActivator.processOrder(new BuyOrder("TSLA", 10, 1));
		assertThat(optional, is(IsNull.notNullValue()));

		Mockito.verify(stockRepository).findOneByName("TSLA");
		Mockito.verify(customerRepository).findOne(1L);

		ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);
		Mockito.verify(customerRepository).save(customerArgumentCaptor.capture());

		Customer customer = customerArgumentCaptor.getValue();
		assertThat(customer.getFreeCash(), is(400));
		assertThat(customer.getName(), is("Test user"));
		Mockito.verifyNoMoreInteractions(customerRepository, stockRepository);
	}

	@Test
	public void buyOrderOfCustomerWithNotEnoughCashAndKnownStock() {
		Mockito.when(stockRepository.findOneByName(Matchers.anyString())).thenReturn(Optional.of(new Stock("TSLA", 10)));
		Mockito.when(customerRepository.findOne(Matchers.anyLong())).thenReturn(new Customer("Test user", 500));

		BuyOrder optional = buyOrderServiceActivator.processOrder(new BuyOrder("TSLA", 10, 1));
		assertThat(optional, is(IsNull.nullValue()));

		Mockito.verify(stockRepository).findOneByName("TSLA");
		Mockito.verify(customerRepository).findOne(1L);
		Mockito.verifyNoMoreInteractions(customerRepository, stockRepository);
	}
}
