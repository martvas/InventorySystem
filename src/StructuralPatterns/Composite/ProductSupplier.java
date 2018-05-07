package StructuralPatterns.Composite;

public class ProductSupplier extends AbstractSupplier implements Supplier {

    ProductSupplier(String name, String address, String bankAccount) {
        super(name, address, bankAccount);
    }

    @Override
    public void showInfo() {
        System.out.println("CreationalPatterns.ProductBuilder supplier: " + name + ". Address: " + address);
    }
}
