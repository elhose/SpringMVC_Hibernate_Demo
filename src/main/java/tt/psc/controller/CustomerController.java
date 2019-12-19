package tt.psc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tt.psc.entity.Customer;
import tt.psc.service.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //need to inject customer Service
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {

        //get customers from the service
        List<Customer> customersList = customerService.getCustomers();

        //add customers to model
        model.addAttribute("customers", customersList);

        return "list-customers";
    }
}
