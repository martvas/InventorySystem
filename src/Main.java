import Product.Product;
import Product.ProductBuilder;
import ProductListFactoryMethod.EnumProductList;
import ProductListFactoryMethod.ListOfProducts;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        ListOfProducts soldProductList = user.createProductList(EnumProductList.SOLD, new Date());
        ProductBuilder productBuilder = new ProductBuilder();
        user.setProductBuilder(productBuilder);
        Product ogurec = user.getProductBuilder().setBarcode(123456L).setName("Ogurec").setBestBefore(new Date()).createProduct();
        Product pomidor = user.getProductBuilder().setBarcode(78456L).setName("Pomidor").setPriceInCents(399).createProduct();
        soldProductList.addProductToList(ogurec);
        soldProductList.addProductToList(pomidor);

        for (Product product : soldProductList.getProductsList()) {
            product.showInfo();
        }
    }
}
