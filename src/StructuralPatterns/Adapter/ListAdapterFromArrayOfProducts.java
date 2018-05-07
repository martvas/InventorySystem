package StructuralPatterns.Adapter;

import CreationalPatterns.ProductBuilder.Product;

import java.util.Arrays;
import java.util.List;

public class ListAdapterFromArrayOfProducts extends ArrayOfProducts implements ProductWorkable<Product> {

    @Override
    public boolean addProduct(Product p) {
        return addProductToArr(p);
    }

    @Override
    public boolean removeProduct(Product p) {
        return removeProductFromArr(p);
    }

    @Override
    public List<Product> getProductList() {
        return Arrays.asList(Arrays.copyOfRange(getProductsArr(), 0, getArrLength()));
    }
}
