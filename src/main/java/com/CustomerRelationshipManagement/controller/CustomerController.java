package com.CustomerRelationshipManagement.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerRelationshipManagement.entity.Customer;
import com.CustomerRelationshipManagement.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    CustomerService customerService;
    // Constructor Injection.
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }



    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int id){
        return customerService.getCustomer(id);
    }

    @PostMapping
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @PutMapping
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer){
        return customerService.modifyCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id){
        return customerService.deleteCustomer(id);
    }

    @PostMapping("/addmultiplecustomer")
    public ResponseEntity<String> addMultipleCustomer(@RequestBody List<Customer> customers){
        return customerService.addMultipleCustomer(customers);
    }

    @GetMapping("/getbyfirstname/{firstName}")
    public ResponseEntity<List<Customer>> getByFirstName(@PathVariable String firstName){
        return customerService.getByFirstName(firstName);
    }

    @GetMapping("/getbylastname/{lastName}")
    public ResponseEntity<List<Customer>> getByLastName(@PathVariable String lastName){
        return customerService.getByLastName(lastName);
    }

    @GetMapping("/getbyage/{age}")
    public ResponseEntity<List<Customer>> getByAge(@PathVariable int age){
        return customerService.getByAge(age);
    }

    @GetMapping("/getlessthanage/{age}")
    public ResponseEntity<List<Customer>> getLessThanAge(@PathVariable int age){
        return customerService.getLessThanAge(age);
    }

    @GetMapping("/getgreaterthanage/{age}")
    public ResponseEntity<List<Customer>> getGreaterThanAge(@PathVariable int age){
        return customerService.getGreaterThanAge(age);
    }

    @GetMapping("/getbyemail/{email}")
    public ResponseEntity<List<Customer>> getByEmail(@PathVariable String email){
        return customerService.getByEmail(email);
    }

    @GetMapping("/getbymobilenumber/{mobileNumber}")
    public ResponseEntity<List<Customer>> getByMobileNumber(@PathVariable String mobileNumber){
        return customerService.getByMobileNumber(mobileNumber);
    }

}
