package customermanager.controller;

import customermanager.models.Customer;
import customermanager.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("delete")
public class DeleteController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String doGet(Model model, @RequestParam Long id){
        Customer customer = customerService.findByID(id);
        model.addAttribute("customer", customer);
        return "delete";
    }

    @PostMapping
    public String doPost(@RequestParam Long id){
        customerService.deleteById(id);
        return "redirect:/";
    }
}
