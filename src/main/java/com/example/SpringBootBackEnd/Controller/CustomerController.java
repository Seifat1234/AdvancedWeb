package com.example.SpringBootBackEnd.Controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.SpringBootBackEnd.Exception.ResourceNotFoundException;
import com.example.SpringBootBackEnd.Model.Customer;
import com.example.SpringBootBackEnd.Repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin

@RestController
@RequestMapping("api/customer")
public class CustomerController {
    
    @Autowired
    private CustomerRepository customerRepository;

    // get all customer
    @GetMapping("/")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
}

   // post customer
   @PostMapping("/")
   public Customer addCustomer(@RequestBody Customer customer) { 
       return customerRepository.save(customer);

}

     //  update customer
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable long id, @RequestBody Customer customer){
        Customer cst = customerRepository.findById(id)
        .orElseThrow( () -> new ResourceNotFoundException("Invalid Id"));
        cst.setName(customer.getName());
        cst.setEmail(customer.getEmail());
        cst.setMedicine(customer.getMedicine());

        Customer cst2 = customerRepository.save(cst);
        return ResponseEntity.ok(cst2);
    }

    // get customer by id
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable long id){
        Customer cst = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid id"));
        return ResponseEntity.ok(cst);
    }

    // delete customer
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEnrollment(@PathVariable long id)
    {
        Customer customer = customerRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("invalid id"));
        customerRepository.delete(customer);

        Map<String,Boolean> response =new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
}
}
