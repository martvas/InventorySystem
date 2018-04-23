package Adapter;

import ProductBuilder.Product;
import ProductBuilder.ProductBuilder;
import SystemUser.InventoryUser;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        InventoryUser inventoryUser = new InventoryUser();
        ProductBuilder productBuilder = new ProductBuilder();
        inventoryUser.setProductBuilder(productBuilder);
        Product ogurec = inventoryUser.getProductBuilder().setBarcode(123456L).setName("Ogurec").setBestBefore(new Date()).createProduct();
        Product pomidor = inventoryUser.getProductBuilder().setBarcode(78456L).setName("Pomidor").setPriceInCents(399).createProduct();
        Product kapusta = inventoryUser.getProductBuilder().setBarcode(45688L).setName("Kapust").setPriceInCents(123).createProduct();

        ProductWorkable<Product> productsListAdapter = new ListAdapterFromArrayOfProducts();
        productsListAdapter.addProduct(ogurec);
        productsListAdapter.addProduct(pomidor);
        productsListAdapter.addProduct(kapusta);
        for (Product product : productsListAdapter.getProductList()) {
            product.showInfo();
        }
    }
}
