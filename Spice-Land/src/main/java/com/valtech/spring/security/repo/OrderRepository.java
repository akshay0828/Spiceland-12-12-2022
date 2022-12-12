package com.valtech.spring.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.spring.security.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{

}
