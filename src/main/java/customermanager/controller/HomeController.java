package customermanager.controller;

import customermanager.models.Customer;
import customermanager.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String index(Model model){
        List<Customer> list = customerService.findAll();
        model.addAttribute("list", list);
        return "index";
    }
}
