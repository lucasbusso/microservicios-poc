package microservicios_poc.mocks;

import microservicios_poc.domain.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomersMockData {
    private static final List<Customer> CUSTOMERS = new ArrayList<>(Arrays.asList(
            new Customer(1, "John Doe 1", "jdoe", "password"),
            new Customer(2, "Jane Doe 2", "janedoe", "password"),
            new Customer(3, "Jane Doe 3", "janedoe", "password"),
            new Customer(4, "Jane Doe 4", "janedoe", "password")
    ));

    public static List<Customer> getCustomers() {
        return CUSTOMERS;
    }
}
