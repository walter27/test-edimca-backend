package ec.com.edimca.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.com.edimca.model.Product;
import ec.com.edimca.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/add")
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		Map<String, Object> response = new HashMap<>();
		String message = "";
		Product productSave =null;
		try {
			if (product.getId() != null) {
				Optional<Product> optionalProduct = productService.findBId(product.getId());
				optionalProduct.get().setDescription(product.getDescription());
				optionalProduct.get().setName(product.getName());
				optionalProduct.get().setPrice(product.getPrice());
				message = "Update product";
				productService.save(optionalProduct.get());
				productSave=optionalProduct.get();
			} else {
				productSave = productService.save(product);
				message = "Registered product";
			}
			response.put("status", "ok");
			response.put("message", message);
			response.put("id", message);
			response.put("product", productSave);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.put("status", "Error");
			response.put("Message", "Error server");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			productService.deleteById(id);
			response.put("status", "ok");
			response.put("Message", "Product deleted");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.put("status", "Error");
			response.put("Message", "Error server");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<?> listProducts() {
		Map<String, Object> response = new HashMap<>();
		List<Product> listProducts = new ArrayList<>();
		try {
			listProducts = productService.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(listProducts);
		} catch (Exception e) {
			response.put("status", "Error");
			response.put("Message", "Error server");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
