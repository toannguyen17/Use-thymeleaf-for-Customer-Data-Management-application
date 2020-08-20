package customermanager.services;

import customermanager.models.Customer;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

//@Component
//@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
@org.springframework.stereotype.Service
public class CustomerService implements Service<Customer> {

    private static Long _id = 0L;

    private static List<Customer> data;

    public CustomerService(){
        data = new ArrayList<Customer>();
    }

    @Override
    public Customer findByID(Long id) {
        Customer customer = null;
        for (Customer customer1: data) {
            if (customer1.getId() == id){
                customer = customer1;
                break;
            }
        }
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<Customer>(data);
    }

    @Override
    public void deleteById(Long id) {
        int count = data.size();
        for (int i = 0; i < count; i++){
            Customer customer = data.get(i);
            if (customer.getId() == id){
                data.remove(i);
                break;
            }
        }
    }
    @Override
    public void insert(Customer element) {
        Long id = ++_id;
        element.setId(id);
        data.add(element);
    }
}
