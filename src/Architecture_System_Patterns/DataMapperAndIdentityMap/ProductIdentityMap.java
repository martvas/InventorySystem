package Architecture_System_Patterns.DataMapperAndIdentityMap;

import Creational_Patterns.ProductBuilder.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductIdentityMap {
    private static Map<Integer, Product> productMap = new HashMap<>();

    static void addProduct(Product product) {
        productMap.put(product.getBarcode(), product);
    }

    public static Product getProduct(Integer barcode) {
        return productMap.get(barcode);
    }

    static void printAll() {
        for (Product product : productMap.values()) {
            product.showInfo();
        }
    }
}
