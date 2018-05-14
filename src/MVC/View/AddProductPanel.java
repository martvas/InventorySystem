package MVC.View;

import CreationalPatterns.ProductBuilder.Product;
import CreationalPatterns.ProductBuilder.ProductBuilder;
import MVC.Controller.MyController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddProductPanel extends JPanel implements ActionListener, AddProductView {

    private JTextField tfBarcode;
    private JTextField tfName;
    private JTextField tfType;
    private JTextField tfPriceInCents;
    private JTextField tfQuantity;
    private JTextField tfSupplierID;
    private JTextField tfDeliveryId;
    private JTextField tfBestBefore;
    private ArrayList<JTextField> integerTextField;
    private MyController myController;

    private JLabel lbInfo;
    private JButton btnSend;
    private JButton btnShowProducts;
    private CardLayout cardLayout;
    private ClientGui parentFrame;
    private JPanel corepanel;


    AddProductPanel(CardLayout cardLayout, JPanel corepanel, ClientGui parentFrame) {
        this.parentFrame = parentFrame;
        this.cardLayout = cardLayout;
        this.corepanel = corepanel;

        initUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btnSend) {
            if (checkFieldsIfDigit() && !tfBarcode.getText().isEmpty() && !tfName.getText().isEmpty()) {
                myController.insertProductToDB(this);
                clearForm();
                lbInfo.setText("Продукт добавлен в базу данных.");
            } else lbInfo.setText("Поля с (int) должны быть введены числа | * - обязательные поля");
        } else if (src == btnShowProducts) {
            cardLayout.show(corepanel, ClientGui.SHOW_PRODUCTS_VIEW);
            myController.setProductsToTable(parentFrame.getShowAllProductsPanel());
        } else {
            throw new RuntimeException("Unknown src = " + src);
        }
    }

    private void clearForm() {
        tfBarcode.setText("");
        tfName.setText("");
        tfType.setText("");
        tfPriceInCents.setText("");
        tfQuantity.setText("");
        tfSupplierID.setText("");
        tfDeliveryId.setText("");
        tfBestBefore.setText("");
    }

    private boolean checkFieldsIfDigit() {
        boolean result = true;
        for (JTextField jTextField : integerTextField) {
            if (!checkIfTextFieldIsDigit(jTextField)) result = false;
        }
        return result;
    }

    private boolean checkIfTextFieldIsDigit(JTextField textField) {
        char[] textArr = textField.getText().toCharArray();
        int len = textArr.length;
        boolean result = true;
        for (int i = 0; i < len; i++) {
            if (!Character.isDigit(textArr[i])) {
                textField.setText("");
                result = false;
            }
        }
        return result;
    }

    @Override
    public MyController getController() {
        return myController;
    }

    @Override
    public void setController(MyController myController) {
        this.myController = myController;
    }

    @Override
    public JComponent getView() {
        return this;
    }

    @Override
    public Product getProductFromForm() {
        return new ProductBuilder()
                .setBarcode(Integer.parseInt(tfBarcode.getText()))
                .setName(tfName.getText())
                .setType(tfType.getText())
                .setPriceInCents(tfPriceInCents.getText().equals("") ? null : Integer.parseInt(tfPriceInCents.getText()))
                .setQuantity(tfQuantity.getText().equals("") ? null : Integer.parseInt(tfQuantity.getText()))
                .setSupplierId(tfSupplierID.getText().equals("") ? null : Integer.parseInt(tfSupplierID.getText()))
                .setDeliveryId(tfDeliveryId.getText().equals("") ? null : Integer.parseInt(tfDeliveryId.getText()))
                .setBestBefore(tfBestBefore.getText())
                .buildProduct();
    }


    private void initUI() {
        setLayout(new BorderLayout());
        JPanel pStart = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        integerTextField = new ArrayList<>();

        lbInfo = new JLabel(" ");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        pStart.add(lbInfo, gbc);

        JLabel lbEmptyRow = new JLabel(" ");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        pStart.add(lbEmptyRow, gbc);

        JLabel lbBarcode = new JLabel("Barcode (int)*: ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        pStart.add(lbBarcode, gbc);

        tfBarcode = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        pStart.add(tfBarcode, gbc);
        integerTextField.add(tfBarcode);

        JLabel lbName = new JLabel("Name*: ");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        pStart.add(lbName, gbc);

        tfName = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        pStart.add(tfName, gbc);

        JLabel lbType = new JLabel("Type: ");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        pStart.add(lbType, gbc);

        tfType = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        pStart.add(tfType, gbc);

        JLabel lbPriceInCents = new JLabel("Price in cents (int): ");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        pStart.add(lbPriceInCents, gbc);

        tfPriceInCents = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        pStart.add(tfPriceInCents, gbc);
        integerTextField.add(tfPriceInCents);

        JLabel lbQuantity = new JLabel("Quantity (int): ");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        pStart.add(lbQuantity, gbc);

        tfQuantity = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        pStart.add(tfQuantity, gbc);
        integerTextField.add(tfQuantity);

        JLabel lbSupplierID = new JLabel("Supplier ID (int): ");
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        pStart.add(lbSupplierID, gbc);

        tfSupplierID = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        pStart.add(tfSupplierID, gbc);
        integerTextField.add(tfSupplierID);

        JLabel lbdeliveryId = new JLabel("Delivery Id (int): ");
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        pStart.add(lbdeliveryId, gbc);

        tfDeliveryId = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        pStart.add(tfDeliveryId, gbc);
        integerTextField.add(tfDeliveryId);

        JLabel lbBestBefore = new JLabel("Best Before: ");
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        pStart.add(lbBestBefore, gbc);

        tfBestBefore = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        pStart.add(tfBestBefore, gbc);

        add(pStart, BorderLayout.CENTER);

        btnSend = new JButton("Send");
        btnSend.addActionListener(this);
        btnShowProducts = new JButton("Show prodcuts");
        btnShowProducts.addActionListener(this);
        setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel pStartB = new JPanel();
        pStartB.add(btnSend);
        pStartB.add(btnShowProducts);
        add(pStartB, BorderLayout.PAGE_END);
    }
}
