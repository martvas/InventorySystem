package Creational_Patterns.ProductBuilder;

public class Product {
    private Integer barcode;
    private String name;
    private String type;
    private Integer priceInCents;
    private Integer quantity;
    private Integer supplierId;
    private Integer deliveryId;
    private String bestBefore;

    Product(Integer barcode, String name, String type, Integer priceInCents, Integer quantity, Integer supplierId, Integer deliveryId, String bestBefore) {
        this.barcode = barcode;
        this.name = name;
        this.type = type;
        this.priceInCents = priceInCents;
        this.quantity = quantity;
        this.supplierId = supplierId;
        this.deliveryId = deliveryId;
        this.bestBefore = bestBefore;
    }

    public void showInfo() {
        System.out.println(name + " " + barcode + " " + priceInCents);
    }

    public Integer getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Integer getPriceInCents() {
        return priceInCents;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public String getBestBefore() {
        return bestBefore;
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
}
