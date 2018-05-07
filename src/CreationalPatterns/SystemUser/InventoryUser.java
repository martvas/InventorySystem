package CreationalPatterns.SystemUser;

import CreationalPatterns.ProductBuilder.ProductBuilder;
import CreationalPatterns.ProductListFactoryMethod.ProductListCreator;

public class InventoryUser extends ProductListCreator {
    private ProductBuilder productBuilder;

    public ProductBuilder getProductBuilder() {
        return productBuilder;
    }

    public void setProductBuilder(ProductBuilder productBuilder) {
        this.productBuilder = productBuilder;
    }
}
