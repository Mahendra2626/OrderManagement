package com.order.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.entity.OrderEntity;

public interface IOrderRepository extends JpaRepository<OrderEntity, Integer> {

}
