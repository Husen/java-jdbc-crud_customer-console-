package repository;

import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepo implements ICustomerRepo{

    private final Connection connection;

    public CustomerRepo(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void addCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO customer(name, address, phone) VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, customer.getName());
        statement.setString(2, customer.getAddress());
        statement.setString(3, customer.getPhone());

        statement.executeUpdate();

        statement.close();

        System.out.println("Data " + customer.getName() + " masuk...");
    }

    @Override
    public Customer getById(Integer id) throws SQLException {
        String sql = "SELECT * FROM customer where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet result = statement.executeQuery();
        String name = "";
        String address = "";
        String phone = "";

        while (result.next()) {
            name = result.getString("name");
            address = result.getString("address");
            phone = result.getString("phone");
            System.out.println(name);
        }
        return new Customer(name, address, phone);
    }

    @Override
    public Customer getByPhone(String phone) throws SQLException {
        String sql = "SELECT * FROM customer where phone=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, phone);

        ResultSet result = statement.executeQuery();
        Customer customer = new Customer();

        while (result.next()) {
            customer.setName(result.getString("name"));
            customer.setAddress(result.getString("address"));
            customer.setPhone(result.getString("phone"));
        }
        return customer;

    }

    @Override
    public void updateById(Integer id, Customer customer) throws SQLException {
        String sql = "UPDATE customer SET name=? , address=? , phone=? where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(4, id);

        statement.setString(1, customer.getName());
        statement.setString(2, customer.getAddress());
        statement.setString(3, customer.getPhone());

        statement.executeUpdate();

        statement.close();

        System.out.println("Data id = " + id + " berhasil di update");

    }

    @Override
    public void deleteById(Integer id) throws SQLException {
        String sql = "delete from customer where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
        System.out.println("Data id = " + id + " berhasil di delete");
    }

    @Override
    public List<Customer> getAll(Integer page, Integer pageSize) throws SQLException {
        int offset = pageSize * (page - 1);
        String sql = "select * from customer order by id asc limit ? offset ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pageSize);
        statement.setInt(2, offset);
        ResultSet result = statement.executeQuery();
        List<Customer> customers = new ArrayList<Customer>();
        while (result.next()) {
            customers.add(new Customer(result.getString("name"), result.getString("address"), result.getString("phone")));
        }
        return customers;
    }

    @Override
    public void addBulkCustomer(List<Customer> customers) throws SQLException {

    }
}
