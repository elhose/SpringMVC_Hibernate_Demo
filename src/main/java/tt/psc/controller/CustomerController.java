package tt.psc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/showFormForAdd")
    public String showFormForAdding(Model model) {

        //add empty Customer object to AddForm, so it can save changes
        Customer theCustomer = new Customer();

        //add attribute to model
        model.addAttribute("customer", theCustomer);

        //return standard view
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String addCustomer(@ModelAttribute("customer") Customer theCustomer) {

        //save coustomer using service
        customerService.saveCustomer(theCustomer);

        //redirect from save customer to mapping /customer/list
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String updateCustomer(@RequestParam("customerId") Integer theInteger, Model model) {

        //get customer from Database
        Customer theCustomer = customerService.getCustomerWithId(theInteger);

        //set customer as a model attribute to pre-populate the form
        model.addAttribute("customer", theCustomer); //String -> "customer"

        //send ovet to our form
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") Integer theId) {

        //delete customer from Database
        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomer(@RequestParam("theSearchName") String searchName, Model model) {

        //get customers from the service
        List<Customer> customersList = customerService.searchForCustomers(searchName);

        //add customers to model
        model.addAttribute("customers", customersList);

        return "list-customers";
    }
}
