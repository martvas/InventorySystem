package ArchitectureSystemPatterns.DataMapperAndIdentityMap;

import CreationalPatterns.ProductBuilder.Product;
import CreationalPatterns.ProductBuilder.ProductBuilder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductMapper {
    private MyDatabase myDatabase;

    public ProductMapper(MyDatabase myDatabase) {
        this.myDatabase = myDatabase;
    }

    Product findByBarcode(Integer barcode) throws SQLException {
        myDatabase.connect();
        Product product = null;
        PreparedStatement statement = myDatabase.getConnection().prepareStatement
                ("SELECT * FROM " + MyDatabase.TABLE_NAME + " WHERE barcode = " + barcode);

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            product = new ProductBuilder()
                    .setBarcode(resultSet.getInt(2))
                    .setName(resultSet.getString(3))
                    .setType(resultSet.getString(4))
                    .setPriceInCents(resultSet.getInt(5))
                    .setQuantity(resultSet.getInt(6))
                    .setSupplierId(resultSet.getInt(7))
                    .setDeliveryId(resultSet.getInt(8))
                    .setBestBefore(resultSet.getString(9))
                    .buildProduct();
        }
        myDatabase.disconnect();
        return product;
    }


    public void insert(Product product) throws SQLException {
        myDatabase.connect();
        PreparedStatement pst = myDatabase.getConnection().prepareStatement
                ("INSERT INTO " + MyDatabase.TABLE_NAME + " " + MyDatabase.ALL_COLUMNS + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        pst.setObject(1, product.getBarcode());
        pst.setObject(2, product.getName());
        pst.setObject(3, product.getType());
        pst.setObject(4, product.getPriceInCents());
        pst.setObject(5, product.getQuantity());
        pst.setObject(6, product.getSupplierId());
        pst.setObject(7, product.getDeliveryId());
        pst.setObject(8, product.getBestBefore());
        pst.execute();
        myDatabase.disconnect();
    }

    public void update(Product product) throws SQLException {
        myDatabase.connect();
        String sqlQuery = new StringBuilder()
                .append("UPDATE " + MyDatabase.TABLE_NAME + " SET ")
                .append(MyDatabase.NAME + " = ? ")
                .append(MyDatabase.TYPE + " = ? ")
                .append(MyDatabase.PRICE_IN_CENTS + " = ? ")
                .append(MyDatabase.QUANTITY + " = ? ")
                .append(MyDatabase.SUPPLIER_ID + " = ? ")
                .append(MyDatabase.DELIVERY_ID + " = ? ")
                .append(MyDatabase.BEST_BEFORE + " = ? ")
                .append("WHERE " + MyDatabase.BARCODE + " = ?;")
                .toString();

        PreparedStatement pst = myDatabase.getConnection().prepareStatement
                (sqlQuery);
        pst.setString(1, product.getName());
        pst.setString(2, product.getType());
        pst.setInt(3, product.getPriceInCents());
        pst.setInt(4, product.getQuantity());
        pst.setInt(5, product.getSupplierId());
        pst.setInt(6, product.getDeliveryId());
        pst.setString(7, product.getBestBefore());

        pst.setInt(8, product.getBarcode());

        pst.execute();
        myDatabase.disconnect();
    }

    public void deleteByBarcode(Integer barcode) throws SQLException {
        myDatabase.connect();
        String sqlQuery = "DELETE FROM " + MyDatabase.TABLE_NAME + " WHERE " + MyDatabase.BARCODE + " = " + barcode;
        Statement st = myDatabase.getConnection().createStatement();
        st.execute(sqlQuery);
        myDatabase.disconnect();
    }


    void getAllProductsToIdentityMap() throws SQLException {
        myDatabase.connect();
        String sqlQuery = "SELECT * FROM " + MyDatabase.TABLE_NAME;
        Statement statement = myDatabase.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        while (resultSet.next()) {
            Product product = new ProductBuilder()
                    .setBarcode(resultSet.getInt(2))
                    .setName(resultSet.getString(3))
                    .setType(resultSet.getString(4))
                    .setPriceInCents(resultSet.getInt(5))
                    .setQuantity(resultSet.getInt(6))
                    .setSupplierId(resultSet.getInt(7))
                    .setDeliveryId(resultSet.getInt(8))
                    .setBestBefore(resultSet.getString(9))
                    .buildProduct();
            ProductIdentityMap.addProduct(product);
        }
        myDatabase.disconnect();
    }

    public List<Product> getAllProductsList() throws SQLException {
        myDatabase.connect();
        List<Product> productsList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM " + MyDatabase.TABLE_NAME;
        Statement statement = myDatabase.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        while (resultSet.next()) {
            Product product = new ProductBuilder()
                    .setBarcode(resultSet.getInt(2))
                    .setName(resultSet.getString(3))
                    .setType(resultSet.getString(4))
                    .setPriceInCents(resultSet.getInt(5))
                    .setQuantity(resultSet.getInt(6))
                    .setSupplierId(resultSet.getInt(7))
                    .setDeliveryId(resultSet.getInt(8))
                    .setBestBefore(resultSet.getString(9))
                    .buildProduct();
            productsList.add(product);
        }
        myDatabase.disconnect();
        return productsList;
    }
}
