package io.portfolio.repo;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerPositionRepository extends JpaRepository<CustomerPosition, Long> {
	Collection<CustomerPosition> findAllByStockName(String stockName);
}
