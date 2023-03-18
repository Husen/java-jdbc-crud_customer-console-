package service;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService {
    public List<Customer> getAll(Integer page, Integer pageSize) throws SQLException;
    public Customer getById(Integer id) throws  SQLException;
    public void addCustomer(Customer customer) throws SQLException;

    public Customer getByPhone(String phone) throws SQLException;

    public void updateById(int id, Customer customer) throws SQLException;
    public void deleteById(int id) throws SQLException;
}
