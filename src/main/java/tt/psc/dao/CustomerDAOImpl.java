package tt.psc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tt.psc.entity.Customer;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    //need to inject session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //create query
        Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);

        //execute query
        List<Customer> customers = query.getResultList();

        //return list of customers
        return customers;
    }
}
