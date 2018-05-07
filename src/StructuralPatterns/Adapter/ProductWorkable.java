package StructuralPatterns.Adapter;

import java.util.List;

public interface ProductWorkable<T> {
    boolean addProduct(T t);

    boolean removeProduct(T t);

    List<T> getProductList();
}
