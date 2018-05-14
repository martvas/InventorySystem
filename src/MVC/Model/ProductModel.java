package MVC.Model;

import ArchitectureSystemPatterns.DataMapperAndIdentityMap.MyDatabase;
import ArchitectureSystemPatterns.DataMapperAndIdentityMap.ProductMapper;
import CreationalPatterns.ProductBuilder.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductModel implements ModelRequestsForController {
    private ProductMapper productMapper;
    private MyDatabase myDatabase;

    public ProductModel() {
        myDatabase = new MyDatabase();
        productMapper = new ProductMapper(myDatabase);
    }


    @Override
    public void insertProductToDatabase(Product product) {
        try {
            productMapper.insert(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Product> getProductsList() {
        try {
            return new ArrayList<>(productMapper.getAllProductsList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void initTable() {
        myDatabase.connect();
        try {
            myDatabase.createNewTableForProducts();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        myDatabase.disconnect();
    }

}
