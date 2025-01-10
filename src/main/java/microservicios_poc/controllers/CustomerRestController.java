package microservicios_poc.controllers;

import microservicios_poc.domain.Customer;
import microservicios_poc.mocks.CustomersMockData;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerRestController {
    private static final List<Customer> CUSTOMERS = CustomersMockData.getCustomers();

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return CUSTOMERS;
    }

    @GetMapping("/customers/{username}")
    public Customer getCustomer(@PathVariable String username) {
       for(Customer item : CUSTOMERS ) {
           if(item.getUserName().equals(username)) {
               return item;
           }
       }
       return null;
    }

    @PostMapping("/customers")
    public Customer postCustomer(@RequestBody Customer customerAdded) {
      CUSTOMERS.add(customerAdded);
        return customerAdded;
    }

    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@RequestBody Customer customerUpdated, @PathVariable int id) {
        for(Customer item : CUSTOMERS ) {
            if(item.getId() == id) {
                item.setUserName(customerUpdated.getUserName());
                item.setName(customerUpdated.getName());
                item.setPassword(customerUpdated.getPassword());
                return item;
            }
        }
        return null;
    }

    @DeleteMapping("/customers/{id}")
    public Customer deleteCustomer(@PathVariable int id) {
        for(Customer item : CUSTOMERS) {
            if(item.getId() == id) {
                CUSTOMERS.remove(item);
                return item;
            }
        }
        return null;
    }

    @PatchMapping("/customers/{id}")
    public Customer patchCustomer(@RequestBody Customer customerUpdated, @PathVariable int id) {
        for(Customer item : CUSTOMERS ) {
            if(item.getId() == id) {
                if(customerUpdated.getUserName() != null) {
                    item.setUserName(customerUpdated.getUserName());
                }
                if(customerUpdated.getPassword() != null) {
                    item.setPassword(customerUpdated.getPassword());
                }
                if(customerUpdated.getName() != null) {
                    item.setName(customerUpdated.getName());
                }
                return item;
            }
        }
        return null;
    }
}
