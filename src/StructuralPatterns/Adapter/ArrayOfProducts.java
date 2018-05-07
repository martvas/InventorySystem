package StructuralPatterns.Adapter;

import CreationalPatterns.ProductBuilder.Product;

public class ArrayOfProducts {
    //Сама реализация кода не очень, так как есть много нюансов с удалением объекта из массива и что будет нулл на его месте.
    //Делал просто для примера, чтобы реализовать адаптер
    private Product[] productsArr;
    private int arrLength;

    public ArrayOfProducts() {
        productsArr = new Product[100];
        arrLength = 0;
    }

    public boolean addProductToArr(Product p) {
        productsArr[arrLength] = p;
        return productsArr[arrLength++] == p;
    }

    boolean removeProductFromArr(Product p) {
        for (int i = 0; i < arrLength; i++) {
            if (p.equals(productsArr[i])) {
                productsArr[i] = null;
                return true;
            }
        }
        return false;
    }

    public int getArrLength() {
        return arrLength;
    }

    public Product[] getProductsArr() {
        return productsArr;
    }
}
