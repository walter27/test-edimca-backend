package ec.com.edimca.service;

import java.util.List;
import java.util.Optional;

import ec.com.edimca.model.Product;

public interface ProductService {

	Product save(Product product);

	void deleteById(Long id);
	
	Optional<Product> findBId(Long id);

	List<Product> findAll();

}
