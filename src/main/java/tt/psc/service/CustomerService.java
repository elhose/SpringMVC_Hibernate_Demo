package tt.psc.service;

import tt.psc.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();
    void saveCustomer(Customer customer);
    Customer getCustomerWithId(Integer theInteger);
    void deleteCustomer(Integer theId);
}
