package com.capgemini.customerapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.customerapp.entity.Customer;

@Repository
public interface CustomerAppRepository extends JpaRepository<Customer, Integer> {

}
