package service;

import model.Customer;
import repository.CustomerRepo;
import repository.ICustomerRepo;

import java.sql.SQLException;
import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepo customerRepo;
    public CustomerService(ICustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public List<Customer> getAll(Integer page, Integer pageSize) throws SQLException {
        return customerRepo.getAll(page, pageSize);
    }

    @Override
    public Customer getById(Integer id) throws SQLException {
        return customerRepo.getById(id);
    }

    @Override
    public void addCustomer(Customer customer) throws SQLException {
        customerRepo.addCustomer(customer);
    }

    @Override
    public Customer getByPhone(String phone) throws SQLException {
        return customerRepo.getByPhone(phone);
    }

    @Override
    public void updateById(int id, Customer customer) throws SQLException {

        customerRepo.updateById(id, customer);
    }

    public void deleteById(int id) throws SQLException {
        customerRepo.deleteById(id);
    }
}
