package customermanager.controller;

import customermanager.models.Customer;
import customermanager.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/create")
public class CreateController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String getFormCreate(){
        return "create";
    }

    @PostMapping
    public String post(String name, String email, Model model)
    {
        Customer customer = new Customer(name, email);
        customerService.insert(customer);
        model.addAttribute("success", true);
        return "create";
    }
}
