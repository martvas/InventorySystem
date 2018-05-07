package ArchitectureSystemPatterns.DataMapperAndIdentityMap;

import CreationalPatterns.ProductBuilder.Product;
import CreationalPatterns.ProductBuilder.ProductBuilder;

import java.sql.*;

public class ProductMapper {
    private Connection connection;

    ProductMapper(Connection connection) {
        this.connection = connection;
    }

    Product findByBarcode(Integer barcode) throws SQLException {
        Product product = null;
        PreparedStatement statement = connection.prepareStatement
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
        return product;
    }


    void insert(Product product) throws SQLException {
        PreparedStatement pst = connection.prepareStatement
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
    }

    public void update(Product product) throws SQLException {
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

        PreparedStatement pst = connection.prepareStatement
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
    }

    public void deleteByBarcode(Integer barcode) throws SQLException {
        String sqlQuery = "DELETE FROM " + MyDatabase.TABLE_NAME + " WHERE " + MyDatabase.BARCODE + " = " + barcode;
        Statement st = connection.createStatement();
        st.execute(sqlQuery);
    }


    void getAllProducts() throws SQLException {
        String sqlQuery = "SELECT * FROM " + MyDatabase.TABLE_NAME;
        Statement statement = connection.createStatement();
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
    }
}
