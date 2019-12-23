package tt.psc.dao;

import tt.psc.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();
    void saveCustomer(Customer theCustomer);
    Customer getCustomer(Integer theInteger);
    void removeCustomer(Integer theId);
    List<Customer> searchForCustomers(String searchName);
}
