package customermanager.controller;

import customermanager.models.Customer;
import customermanager.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("update")
public class UpdateController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String getUpdate(Model model, @RequestParam Long id){
        List<Customer> list = customerService.findAll();
        Customer customer = null;
        for (Customer customer1: list){
            if (customer1.getId() == id){
                customer = customer1;
                break;
            }
        }
        model.addAttribute("customer", customer);
        return "update";
    }

    @PostMapping
    public String postUpdate(String name, String email, Model model, @RequestParam Long id){
        List<Customer> list = customerService.findAll();
        Customer customer = null;
        for (Customer customer1: list){
            if (customer1.getId() == id){
                customer = customer1;
                customer.setName(name);
                customer.setEmail(email);
                break;
            }
        }
        model.addAttribute("customer", customer);
        model.addAttribute("success", true);
        return "update";
    }
}
