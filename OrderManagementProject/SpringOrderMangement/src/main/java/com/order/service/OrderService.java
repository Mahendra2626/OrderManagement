package com.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.entity.OrderEntity;
import com.order.exception.ResourceNotFoundException;



@Service
public class OrderService implements IOrderService{
	@Autowired
	IOrderRepository orderRepository;

	@Override
	public  Integer saveOrder(OrderEntity order) {
	
		OrderEntity savedOrder = orderRepository.save(order);
		return savedOrder.getId();
	}

	@Override
	public List<OrderEntity> getAllorders() {
		return orderRepository.findAll();
	}

	@Override
	public Optional<OrderEntity> getOrder(Integer id) {
		
		return orderRepository.findById(id);
	}

	@Override
	public void deleteOrder(Integer id) {
		orderRepository.deleteById(id);
		
	}

	@Override
	public Integer updateOrder(OrderEntity order, Integer id) {
		OrderEntity updatedOrder =	orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
		updatedOrder.setDevice(order.getDevice());
		updatedOrder.setBrand(order.getBrand());
		updatedOrder.setPrice(order.getPrice());
		orderRepository.save(updatedOrder);
		return updatedOrder.getId();
	}

	
	}


