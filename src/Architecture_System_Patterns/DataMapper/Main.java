package Architecture_System_Patterns.DataMapper;

import Creational_Patterns.ProductBuilder.Product;
import Creational_Patterns.ProductBuilder.ProductBuilder;

import java.sql.SQLException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws SQLException {
        MyDatabase myDatabase = new MyDatabase();
        myDatabase.connect();
        myDatabase.createNewTableForProducts();
        ProductMapper productMapper = new ProductMapper(myDatabase.getConnection());

        Product ogurec = new ProductBuilder().setBarcode(123456).setName("Ogurec").setPriceInCents(567).setBestBefore(new Date().toString()).buildProduct();
        Product pomidor = new ProductBuilder().setBarcode(78456).setName("Pomidor").setPriceInCents(399).buildProduct();
        Product kapusta = new ProductBuilder().setBarcode(45688).setName("Kapust").setPriceInCents(123).buildProduct();

        productMapper.insert(ogurec);
        productMapper.insert(pomidor);
        productMapper.insert(kapusta);

        Product productToFind = productMapper.findByBarcode(123456);
        System.out.println("Продукт найденный по баркоду: ");
        productToFind.showInfo();
        System.out.println("_______________________________");
        System.out.println("Продукты в IdentityMap");

        productMapper.getAllProducts();
        ProductIdentityMap.printAll();

        myDatabase.disconnect();
    }
}
