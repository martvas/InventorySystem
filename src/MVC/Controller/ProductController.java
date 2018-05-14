package MVC.Controller;

import CreationalPatterns.ProductBuilder.Product;
import MVC.Model.ModelRequestsForController;
import MVC.View.AddProductView;
import MVC.View.ShowProductsView;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductController implements MyController {
    private ModelRequestsForController productModel;

    public ProductController(ModelRequestsForController productModel) {
        this.productModel = productModel;
    }

    @Override
    public void insertProductToDB(AddProductView view) {
        try {
            productModel.insertProductToDatabase(view.getProductFromForm());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setProductsToTable(ShowProductsView view) {
        try {
            ArrayList<Product> tempList = productModel.getProductsList();
            if (tempList != null) {
                view.setProductListToTable(tempList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
