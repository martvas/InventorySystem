package Creational_Patterns.SystemUser;

import Creational_Patterns.ProductBuilder.ProductBuilder;
import Creational_Patterns.ProductListFactoryMethod.ProductListCreator;

public class InventoryUser extends ProductListCreator {
    private ProductBuilder productBuilder;

    public ProductBuilder getProductBuilder() {
        return productBuilder;
    }

    public void setProductBuilder(ProductBuilder productBuilder) {
        this.productBuilder = productBuilder;
    }
}
