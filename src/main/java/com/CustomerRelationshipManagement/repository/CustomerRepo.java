package com.CustomerRelationshipManagement.repository;

import com.CustomerRelationshipManagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    List<Customer> findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
    List<Customer> findByAge(int age);

    @Query("FROM Customer c WHERE c.age < :age")
    List<Customer> findByLessThanAge(int age);

    @Query("FROM Customer c WHERE c.age > :age")
    List<Customer> findByGreaterThanAge(int age);

    List<Customer> findByEmail(String email);

    List<Customer> findByMobileNumber(String mobileNumber);
}
