package controller;

import model.Customer;
import service.ICustomerService;
import util.View;

import java.sql.SQLException;
import java.util.List;

public class CustomerController implements ICustomerController{
    private ICustomerService customerService;
    private View view = new View();

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void getAll(Integer page, Integer pageSize) throws SQLException {
        List<Customer> customers = customerService.getAll(page, pageSize);
        view.getAllView(customers);
    }

    @Override
    public void addCustomer(String name, String address, String phone) throws SQLException {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setAddress(address);
        customer.setPhone(phone);
        customerService.addCustomer(customer);
    }

    @Override
    public void getById(Integer id) throws SQLException {
        customerService.getById(id);
        Customer customer = customerService.getById(id);
        if (customer.getName() != "") {
            view.getByIdView(customer);
        } else {
            System.err.println("Data not found");
        }
    }

    @Override
    public void getByPhone(String phone) throws SQLException{
        customerService.getByPhone(phone);
        Customer customer = customerService.getByPhone(phone);
        if (customer.getName() != null) {
            view.getByPhoneView(customer);
        } else {
            System.err.println("Data not found");
        }
    }

    @Override
    public void updateById(int id, String name, String address, String phone) throws SQLException {
        Customer customer = customerService.getById(id);
        String names = name == null || name.length() == 0 ? customer.getName() : name;
        String addressS = address == null || address.length() == 0 ? customer.getAddress() : address;
        String phones = phone == null || phone.length() == 0 ? customer.getPhone() : phone;
        customer.setName(names);
        customer.setAddress(addressS);
        customer.setPhone(phones);
        customerService.updateById(id, customer);
    }

    @Override
    public void deleteById(int id) throws SQLException {
        Customer customer = customerService.getById(id);
//        System.out.println(customer.getName());
        if (customer.getName() != "") {
            customerService.deleteById(id);
        } else {
            System.out.println("Data id tidak ada");
        }
    }
}
