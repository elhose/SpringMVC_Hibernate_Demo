package tt.psc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tt.psc.dao.CustomerDAO;
import tt.psc.entity.Customer;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    //need to inject customerDAO
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomerWithId(Integer theInteger) {
        return customerDAO.getCustomer(theInteger);
    }

    @Override
    @Transactional
    public void deleteCustomer(Integer theId) {
        customerDAO.removeCustomer(theId);
    }

    @Override
    @Transactional
    public List<Customer> searchForCustomers(String searchName) {
        return customerDAO.searchForCustomers(searchName);
    }
}
