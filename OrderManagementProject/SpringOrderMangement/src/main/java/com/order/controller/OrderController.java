package com.order.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.OrderEntity;
import com.order.service.IOrderService;




@RestController
public class OrderController {
	@Autowired
	IOrderService orderService;
	
	@PostMapping("/order")
	Integer createOrder(@RequestBody OrderEntity order) {
		Integer id = orderService.saveOrder(order);
		return id ;}
	@GetMapping("/allorders")
	public List<OrderEntity> getOrders(){
		   return orderService.getAllorders();
	   }
	@GetMapping("/order/{id}")
	   public Optional<OrderEntity> getOrder(@PathVariable Integer id){
	   
		   Optional<OrderEntity> order = orderService.getOrder(id);
		   return order;
		   }
	
	

	   @DeleteMapping("/order/{id}")
	   public ResponseEntity<OrderEntity> deleteorder(@PathVariable Integer id){
		 System.out.println(id);
		  ResponseEntity<OrderEntity> responseEntity =new ResponseEntity<>(HttpStatus.OK);
		  try {
			  orderService.deleteOrder(id);
		  }catch(Exception e) {
			  e.printStackTrace();
			  responseEntity =new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
		return responseEntity;
	   }
		
		@PutMapping("/updateorder/{id}")
		public ResponseEntity<OrderEntity> updateEntity(@PathVariable Integer id , @RequestBody OrderEntity order){
		
			ResponseEntity<OrderEntity> responseEntity =new ResponseEntity<>(HttpStatus.OK);
			  try {
				  orderService.updateOrder(order, id);
			  }catch(Exception e) {
				  e.printStackTrace();
				  responseEntity =new ResponseEntity<>(HttpStatus.NOT_FOUND);
			  }
			return responseEntity;
		}
		
	
	
}
