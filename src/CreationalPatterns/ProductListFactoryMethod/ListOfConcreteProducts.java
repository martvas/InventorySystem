package CreationalPatterns.ProductListFactoryMethod;

import CreationalPatterns.ProductBuilder.Product;

import java.util.ArrayList;
import java.util.Date;

public class ListOfConcreteProducts implements ListOfProducts {
    private Date date;
    private ArrayList<Product> productList;

    ListOfConcreteProducts(Date date) {
        this.date = date;
        productList = new ArrayList<>();
    }

    @Override
    public boolean addProductToList(Product product) {
        return productList.add(product);
    }

    @Override
    public boolean removeProductFromList(Product product) {
        return productList.remove(product);
    }

    @Override
    public ArrayList<Product> getProductsList() {
        return productList;
    }
}
