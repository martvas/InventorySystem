package ProductBuilder;

import java.util.Date;

public class Product {
    private Long barcode;
    private String name;
    private String type;
    private Integer priceInCents;
    private Integer quantity;
    private Integer supplierId;
    private Integer deliveryId;
    private Date bestBefore;

    Product(Long barcode, String name, String type, Integer priceInCents, Integer quantity, Integer supplierId, Integer deliveryId, Date bestBefore) {
        this.barcode = barcode;
        this.name = name;
        this.type = type;
        this.priceInCents = priceInCents;
        this.quantity = quantity;
        this.supplierId = supplierId;
        this.deliveryId = deliveryId;
        this.bestBefore = bestBefore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return barcode.equals(product.barcode) && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        int result = barcode.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    public void showInfo() {
        System.out.println(name + " " + barcode + " " + priceInCents);
    }
}
