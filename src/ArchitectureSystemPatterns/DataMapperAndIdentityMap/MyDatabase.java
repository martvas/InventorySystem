package ArchitectureSystemPatterns.DataMapperAndIdentityMap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDatabase {
    static final String TABLE_NAME = "products";
    static final String BARCODE = "barcode";
    static final String NAME = "name";
    static final String TYPE = "type";
    static final String PRICE_IN_CENTS = "price_in_cents";
    static final String QUANTITY = "quantity";
    static final String SUPPLIER_ID = "supplier_id";
    static final String DELIVERY_ID = "delivery_id";
    static final String BEST_BEFORE = "best_before";

    static final String ALL_COLUMNS = "(barcode, name, type, price_in_cents, quantity, supplier_id, delivery_id, best_before)";

    private Connection connection;


    public void createNewTableForProducts() throws SQLException {
//        Statement stToDrop = connection.createStatement();
//        stToDrop.execute("DROP TABLE " + TABLE_NAME);

        Statement st = connection.createStatement();
        String createTableQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (\n" +
                "    id             INTEGER PRIMARY KEY\n" +
                "                           NOT NULL,\n" +
                "    " + BARCODE + "        INTEGER NOT NULL\n" +
                "                           UNIQUE,\n" +
                "    " + NAME + "           TEXT    NOT NULL,\n" +
                "    " + TYPE + "           TEXT,\n" +
                "    " + PRICE_IN_CENTS + " INT,\n" +
                "    " + QUANTITY + "       INT     DEFAULT (0),\n" +
                "    " + SUPPLIER_ID + "    INT,\n" +
                "    " + DELIVERY_ID + "    INT,\n" +
                "    " + BEST_BEFORE + "    TEXT\n" +
                ");";

        st.execute(createTableQuery);
    }

    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + TABLE_NAME + ".db");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Connection getConnection() {
        return connection;
    }
}
