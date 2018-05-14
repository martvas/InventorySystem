package MVC.View;

import CreationalPatterns.ProductBuilder.Product;
import MVC.Controller.MyController;

public interface AddProductView extends View<MyController> {
    Product getProductFromForm();
}
