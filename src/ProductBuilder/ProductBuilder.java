package ProductBuilder;

import java.util.Date;

public class ProductBuilder {
    private Long barcode;
    private String name;
    private String type;
    private Integer priceInCents;
    private Integer quantity;
    private Integer supplierId;
    private Integer deliveryId;
    private Date bestBefore;

    public ProductBuilder setBarcode(Long barcode) {
        this.barcode = barcode;
        return this;
    }

    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public ProductBuilder setPriceInCents(Integer priceInCents) {
        this.priceInCents = priceInCents;
        return this;
    }

    public ProductBuilder setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public ProductBuilder setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
        return this;
    }

    public ProductBuilder setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
        return this;
    }

    public ProductBuilder setBestBefore(Date bestBefore) {
        this.bestBefore = bestBefore;
        return this;
    }

    public Product createProduct() {
        return new Product(barcode, name, type, priceInCents, quantity, supplierId, deliveryId, bestBefore);
    }
}
