import Product.ProductBuilder;
import ProductListFactoryMethod.ProductListCreator;

class User extends ProductListCreator {
    private ProductBuilder productBuilder;

    ProductBuilder getProductBuilder() {
        return productBuilder;
    }

    void setProductBuilder(ProductBuilder productBuilder) {
        this.productBuilder = productBuilder;
    }
}
