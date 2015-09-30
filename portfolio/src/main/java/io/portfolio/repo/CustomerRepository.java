package io.portfolio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gfoster on 9/25/15.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long>{
}
