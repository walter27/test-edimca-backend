package ec.com.edimca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.edimca.model.Order;
import ec.com.edimca.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Override
	public void save(Order order) {
		orderRepository.save(order);
	}

}
