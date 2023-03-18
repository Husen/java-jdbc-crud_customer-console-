import controller.CustomerController;
import controller.ICustomerController;
import model.Customer;
import repository.CustomerRepo;
import repository.ICustomerRepo;
import service.CustomerService;
import service.ICustomerService;
import util.Connector;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connector conn = new Connector();
        Connection connection = conn.connect();

        ICustomerRepo customerRepo = new CustomerRepo(connection);
        ICustomerService customerService = new CustomerService(customerRepo);
        ICustomerController customerController = new CustomerController(customerService);

        try {
            System.out.println();
//            customerController.addCustomer("bimo", "banding", "089992928"); // create data customer
            customerController.getAll(1,10);
//            customerController.getById(1); // getById
//            customerController.deleteById(70);
//            customerController.getByPhone("077388828s"); // getByPhone
//            customerController.updateById(1, "ucok", "cianjur", "0983979073"); // update by Id

            System.out.println();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            conn.close();
        }


    }
}
