package StructuralPatterns.Adapter;

import CreationalPatterns.ProductBuilder.Product;
import CreationalPatterns.ProductBuilder.ProductBuilder;
import CreationalPatterns.SystemUser.InventoryUser;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        InventoryUser inventoryUser = new InventoryUser();
        ProductBuilder productBuilder = new ProductBuilder();
        inventoryUser.setProductBuilder(productBuilder);
        Product ogurec = inventoryUser.getProductBuilder().setBarcode(123456).setName("Ogurec").setBestBefore(new Date().toString()).buildProduct();
        Product pomidor = inventoryUser.getProductBuilder().setBarcode(78456).setName("Pomidor").setPriceInCents(399).buildProduct();
        Product kapusta = inventoryUser.getProductBuilder().setBarcode(45688).setName("Kapust").setPriceInCents(123).buildProduct();

        ProductWorkable<Product> productsListAdapter = new ListAdapterFromArrayOfProducts();
        productsListAdapter.addProduct(ogurec);
        productsListAdapter.addProduct(pomidor);
        productsListAdapter.addProduct(kapusta);
        for (Product product : productsListAdapter.getProductList()) {
            product.showInfo();
        }
    }
}
