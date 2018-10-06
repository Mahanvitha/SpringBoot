package com.capgemini.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.product.entities.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
