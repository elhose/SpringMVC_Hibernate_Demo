package tt.psc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tt.psc.dao.CustomerDAO;
import tt.psc.entity.Customer;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //need to inject customer DAO
    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCustomers(Model model) {

        //get customers from the dao
        List<Customer> customersList = customerDAO.getCustomers();

        //add customers to model
        model.addAttribute("customers", customersList);

        return "list-customers";
    }
}
