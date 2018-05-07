package StructuralPatterns.Composite;

public class MeatSupplier extends AbstractSupplier implements Supplier {
    MeatSupplier(String name, String address, String bankAccount) {
        super(name, address, bankAccount);
    }

    @Override
    public void showInfo() {
        System.out.println("Alcohol supplier: " + name + ". Address: " + address);
    }
}
