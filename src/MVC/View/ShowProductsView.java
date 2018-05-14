package MVC.View;

import CreationalPatterns.ProductBuilder.Product;
import MVC.Controller.MyController;

import java.util.ArrayList;

public interface ShowProductsView<M> extends View<MyController> {
    void setProductListToTable(ArrayList<Product> productList);
}
