package CreationalPatterns.ProductListFactoryMethod;

import CreationalPatterns.ProductBuilder.Product;

import java.util.ArrayList;

public interface ListOfProducts {
    boolean addProductToList(Product product);

    boolean removeProductFromList(Product product);

    ArrayList<Product> getProductsList();
}
