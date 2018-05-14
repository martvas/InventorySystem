package MVC.View;

import CreationalPatterns.ProductBuilder.Product;
import MVC.Controller.MyController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShowAllProductsPanel extends JPanel implements ActionListener, ShowProductsView<MyController> {

    private static final String[] TBL_HEAD = {"Barcode", "Name", "Type", "Price", "Quantity", "Sup. Id", "Del. Id", "Before"};
    private JPanel corepanel;
    private CardLayout cardLayout;
    private JLabel lbInfoMain;
    private JTable tProductTable;

    private JButton btnBack;

    private MyController myController;

    ShowAllProductsPanel(CardLayout cardLayout, JPanel corepanel) {
        this.cardLayout = cardLayout;
        this.corepanel = corepanel;

        initUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btnBack) {
            cardLayout.show(corepanel, ClientGui.LOGIN_VIEW);
        } else {
            throw new RuntimeException("Unknown src = " + src);
        }
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
    public void setProductListToTable(ArrayList<Product> productList) {
        DefaultTableModel dtm = new DefaultTableModel(TBL_HEAD, 0);
        for (Product product : productList) {
            dtm.addRow(product.toStringArr());
        }
        tProductTable.setModel(dtm);
    }

    private void initUI() {
        setLayout(new BorderLayout());
        JPanel pMainUp = new JPanel(new BorderLayout());
        lbInfoMain = new JLabel(" ");
        pMainUp.add(lbInfoMain, BorderLayout.LINE_START);

        JPanel pMain = new JPanel(new BorderLayout());
        JPanel pTable = new JPanel();

        tProductTable = new JTable();
        tProductTable.setAutoscrolls(true);
        JScrollPane pane = new JScrollPane(tProductTable);
        pTable.add(pane);

        pMain.add(pTable, BorderLayout.CENTER);

        btnBack = new JButton("Back");
        btnBack.addActionListener(this);

        add(pMainUp, BorderLayout.NORTH);
        add(pMain, BorderLayout.CENTER);
        add(btnBack, BorderLayout.SOUTH);

        setBorder(new EmptyBorder(10, 10, 10, 10));
    }

}
