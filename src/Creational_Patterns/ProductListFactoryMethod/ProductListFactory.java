package Creational_Patterns.ProductListFactoryMethod;

import java.util.Date;

public interface ProductListFactory {
    ListOfProducts createProductList(EnumProductList enumProductList, Date date);
}