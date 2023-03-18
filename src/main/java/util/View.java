package util;

import model.Customer;

import java.util.List;

public class View {

    public void getAllView(List<Customer> customers) {
        for(Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }
    public void getByIdView(Customer customer) {
        System.out.println("nama : " + customer.getName() + " | address : " + customer.getAddress() + " | phone :" + customer.getPhone());
    }

    public void getByPhoneView(Customer customer) {
        System.out.println("nama : " + customer.getName() + " | address : " + customer.getAddress() + " | phone :" + customer.getPhone());
    }
}
