package Creational_Patterns.ProductListFactoryMethod;

import java.util.Date;

public class ProductListCreator implements ProductListFactory {
    @Override
    public ListOfProducts createProductList(EnumProductList enumProductList, Date date) {
        ListOfProducts productList = null;
        switch (enumProductList) {
            case SOLD:
                productList = new SoldProductList(date);
                break;
            case SPOILED:
                productList = new SoldProductList(date);
                break;
        }
        return productList;
    }
}
