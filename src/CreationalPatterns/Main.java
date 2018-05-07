package CreationalPatterns;

import CreationalPatterns.ProductBuilder.Product;
import CreationalPatterns.ProductBuilder.ProductBuilder;
import CreationalPatterns.ProductListFactoryMethod.EnumProductList;
import CreationalPatterns.ProductListFactoryMethod.ListOfProducts;
import CreationalPatterns.SystemUser.InventoryUser;
import StructuralPatterns.Adapter.ArrayOfProducts;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        InventoryUser inventoryUser = new InventoryUser();
        ProductBuilder productBuilder = new ProductBuilder();
        inventoryUser.setProductBuilder(productBuilder);
        Product ogurec = inventoryUser.getProductBuilder().setBarcode(123456).setName("Ogurec").setBestBefore(new Date().toString()).buildProduct();
        Product pomidor = inventoryUser.getProductBuilder().setBarcode(78456).setName("Pomidor").setPriceInCents(399).buildProduct();
        ArrayOfProducts arrayOfProducts = new ArrayOfProducts();
        arrayOfProducts.addProductToArr(ogurec);
        arrayOfProducts.addProductToArr(pomidor);
        for (int i = 0; i < arrayOfProducts.getArrLength(); i++) {
            arrayOfProducts.getProductsArr()[i].showInfo();
        }
    }


    public static void main2(String[] args) {
        InventoryUser inventoryUser = new InventoryUser();
        ListOfProducts soldProductList = inventoryUser.createProductList(EnumProductList.SOLD, new Date());
        ProductBuilder productBuilder = new ProductBuilder();
        inventoryUser.setProductBuilder(productBuilder);
        Product ogurec = inventoryUser.getProductBuilder().setBarcode(123456).setName("Ogurec").setBestBefore(new Date().toString()).buildProduct();
        Product pomidor = inventoryUser.getProductBuilder().setBarcode(78456).setName("Pomidor").setPriceInCents(399).buildProduct();
        soldProductList.addProductToList(ogurec);
        soldProductList.addProductToList(pomidor);

        for (Product product : soldProductList.getProductsList()) {
            product.showInfo();
        }
    }
}
