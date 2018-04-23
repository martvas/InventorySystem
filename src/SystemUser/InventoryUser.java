package SystemUser;

import ProductBuilder.ProductBuilder;
import ProductListFactoryMethod.ProductListCreator;

public class InventoryUser extends ProductListCreator {
    private ProductBuilder productBuilder;

    public ProductBuilder getProductBuilder() {
        return productBuilder;
    }

    public void setProductBuilder(ProductBuilder productBuilder) {
        this.productBuilder = productBuilder;
    }
}
