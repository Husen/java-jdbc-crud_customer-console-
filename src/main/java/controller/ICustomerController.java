package controller;

import model.Customer;

import java.sql.SQLException;

public interface ICustomerController {
    public void getAll(Integer page, Integer pageSize) throws SQLException;
    public void addCustomer(String name, String address, String phone) throws SQLException;
    public void getById(Integer id) throws SQLException;

    public void getByPhone(String phone) throws SQLException;

    public void updateById(int id, String name, String address, String phone) throws SQLException;
    public void deleteById(int id) throws SQLException;
}
