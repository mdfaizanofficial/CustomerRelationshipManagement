package com.CustomerRelationshipManagement.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.CustomerRelationshipManagement.entity.Customer;
import com.CustomerRelationshipManagement.repository.CustomerRepo;

@Service
public class CustomerService {
    CustomerRepo customerRepo;
    // constructor injection
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }



    public ResponseEntity<String> addCustomer(Customer customer) {
        String status = null;
        try{
            customerRepo.save(customer);
            status = "Value Added";
        }catch (Exception e){
            e.printStackTrace();
        }

        if(status != null)
            return new ResponseEntity<>(status, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }


    public ResponseEntity<Customer> getCustomer(int id) {
        try{
            Customer customer = customerRepo.findById(id).get();
            return new ResponseEntity<>(customer, HttpStatus.FOUND);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Customer>> getCustomers(){
        try {
            List<Customer> customers = customerRepo.findAll();
            return new ResponseEntity<>(customers, HttpStatus.FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> modifyCustomer(Customer customer) {
        try {
            customerRepo.save(customer);
            return new ResponseEntity<>("User Modified.", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    public ResponseEntity<String> deleteCustomer(int id) {
        try {
            customerRepo.deleteById(id);
            return new ResponseEntity<>("Customer Deleted!!", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> addMultipleCustomer(List<Customer> customers) {
        try {
            customerRepo.saveAll(customers);
            return new ResponseEntity<>("Customers added.", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<List<Customer>> getByFirstName(String firstName) {
        try {
            List<Customer> customers = customerRepo.findByFirstName(firstName);
            return new ResponseEntity<>(customers, HttpStatus.FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<List<Customer>> getByLastName(String lastName) {
        try {
            List<Customer> customers = customerRepo.findByLastName(lastName);
            return new ResponseEntity<>(customers, HttpStatus.FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Customer>> getByAge(int age) {
        try{
            List<Customer> customers = customerRepo.findByAge(age);
            return new ResponseEntity<>(customers, HttpStatus.FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Customer>> getLessThanAge(int age) {
        try {
            List<Customer> customers = customerRepo.findByLessThanAge(age);
            return new ResponseEntity<>(customers, HttpStatus.FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<List<Customer>> getGreaterThanAge(int age) {
        try {
            List<Customer> customers = customerRepo.findByGreaterThanAge(age);
            return new ResponseEntity<>(customers, HttpStatus.FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<List<Customer>> getByEmail(String email) {
        try{
            List<Customer> customers = customerRepo.findByEmail(email);
            return new ResponseEntity<>(customers, HttpStatus.FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<List<Customer>> getByMobileNumber(String mobileNumber) {
        try {
            List<Customer> customers = customerRepo.findByMobileNumber(mobileNumber);
            return new ResponseEntity<>(customers, HttpStatus.FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
