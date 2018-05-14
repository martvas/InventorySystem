package MVC.View;

import MVC.Controller.MyController;
import MVC.Controller.ProductController;
import MVC.Model.ModelRequestsForController;
import MVC.Model.ProductModel;

import javax.swing.*;
import java.awt.*;

public class ClientGui extends JFrame {
    public static final String LOGIN_VIEW = "view.login";
    public static final String SHOW_PRODUCTS_VIEW = "view.show_products";

    private ShowAllProductsPanel showAllProductsPanel;

    private ClientGui() {
        setTitle("My Inventory System");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel corePanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        corePanel.setLayout(cardLayout);

        AddProductPanel addProductPanel = new AddProductPanel(cardLayout, corePanel, this);
        showAllProductsPanel = new ShowAllProductsPanel(cardLayout, corePanel);
        ModelRequestsForController modelRequestsForController = new ProductModel();
        modelRequestsForController.initTable();
        MyController myController = new ProductController(modelRequestsForController);
        addProductPanel.setController(myController);
        showAllProductsPanel.setController(myController);

        corePanel.add(addProductPanel, LOGIN_VIEW);
        corePanel.add(showAllProductsPanel, SHOW_PRODUCTS_VIEW);
        add(corePanel);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(true);
        cardLayout.show(corePanel, LOGIN_VIEW);
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClientGui());

    }

    ShowAllProductsPanel getShowAllProductsPanel() {
        return showAllProductsPanel;
    }


}

