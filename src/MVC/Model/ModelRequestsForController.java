package MVC.Model;

import CreationalPatterns.ProductBuilder.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ModelRequestsForController {
    void insertProductToDatabase(Product product) throws SQLException;

    ArrayList<Product> getProductsList() throws SQLException;

    void initTable();
}
