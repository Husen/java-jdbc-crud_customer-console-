package repository;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerRepo {
    public void addCustomer(Customer customer) throws SQLException;
    public Customer getById(Integer id) throws SQLException;
    public Customer getByPhone(String phone) throws SQLException;
    public void updateById(Integer id, Customer customer) throws SQLException;
    public void deleteById(Integer id) throws SQLException;
    public List<Customer> getAll(Integer page, Integer pageSize) throws SQLException;
    public void addBulkCustomer(List<Customer> customers) throws SQLException;

}
