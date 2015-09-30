package io.portfolio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by gfoster on 9/25/15.
 */
public interface StockRepository extends JpaRepository<Stock, Long>{
    Optional<Stock> findOneByName(String stockName);
}
