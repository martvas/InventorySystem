package Composite;

public class AlcoholSupplier extends AbstractSupplier implements Supplier {
    AlcoholSupplier(String name, String address, String bankAccount) {
        super(name, address, bankAccount);
    }

    @Override
    public void showInfo() {
        System.out.println("Alcohol supplier: " + name + ". Address: " + address);
    }
}
