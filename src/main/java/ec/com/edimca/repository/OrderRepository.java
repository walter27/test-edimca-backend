package ec.com.edimca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.com.edimca.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
