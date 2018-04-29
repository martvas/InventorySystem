package Structural_Patterns.Composite;

public class ProductSupplier extends AbstractSupplier implements Supplier {

    ProductSupplier(String name, String address, String bankAccount) {
        super(name, address, bankAccount);
    }

    @Override
    public void showInfo() {
        System.out.println("Creational_Patterns.ProductBuilder supplier: " + name + ". Address: " + address);
    }
}
