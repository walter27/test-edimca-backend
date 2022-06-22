package ec.com.edimca.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.com.edimca.model.Order;
import ec.com.edimca.model.OrderDetail;
import ec.com.edimca.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping("/add")
	public ResponseEntity<?> addOrder(@RequestBody Order order) {
		Map<String, Object> response = new HashMap<>();
		try {
			for (OrderDetail orderDetail : order.getListDetails()) {
				orderDetail.setDate(new Date());
				orderDetail.setOrder(order);
			}
			order.setDate(new Date());
			orderService.save(order);
			response.put("status", "ok");
			response.put("Message", "Registered order");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.put("status", "Error");
			response.put("Message", "Error server");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}





}
