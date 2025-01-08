package microservicios_poc.controllers;

import microservicios_poc.domain.Customer;
import microservicios_poc.mocks.CustomersMockData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CustomerRestController {

    @GetMapping("customers")
    public List<Customer> getCustomers() {
        return CustomersMockData.getCustomers();
    }

    @GetMapping("customers/{username}")
    public Customer getCustomer(@PathVariable String username) {
       for(Customer item : CustomersMockData.getCustomers() ) {
           if(item.getUserName().equals(username)) {
               return item;
           }
       }
       return null;
    }

}
