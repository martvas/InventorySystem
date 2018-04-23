import Adapter.ArrayOfProducts;
import ProductBuilder.Product;
import ProductBuilder.ProductBuilder;
import ProductListFactoryMethod.EnumProductList;
import ProductListFactoryMethod.ListOfProducts;
import SystemUser.InventoryUser;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        InventoryUser inventoryUser = new InventoryUser();
        ProductBuilder productBuilder = new ProductBuilder();
        inventoryUser.setProductBuilder(productBuilder);
        Product ogurec = inventoryUser.getProductBuilder().setBarcode(123456L).setName("Ogurec").setBestBefore(new Date()).createProduct();
        Product pomidor = inventoryUser.getProductBuilder().setBarcode(78456L).setName("Pomidor").setPriceInCents(399).createProduct();
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
        Product ogurec = inventoryUser.getProductBuilder().setBarcode(123456L).setName("Ogurec").setBestBefore(new Date()).createProduct();
        Product pomidor = inventoryUser.getProductBuilder().setBarcode(78456L).setName("Pomidor").setPriceInCents(399).createProduct();
        soldProductList.addProductToList(ogurec);
        soldProductList.addProductToList(pomidor);

        for (Product product : soldProductList.getProductsList()) {
            product.showInfo();
        }
    }
}
