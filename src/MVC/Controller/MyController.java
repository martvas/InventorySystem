package MVC.Controller;

import MVC.View.AddProductView;
import MVC.View.ShowProductsView;

public interface MyController {
    void insertProductToDB(AddProductView view);

    void setProductsToTable(ShowProductsView view);
}
