package ec.com.edimca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.com.edimca.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
