package Structural_Patterns.Composite;

abstract class AbstractSupplier {
    String name;
    String address;
    private String bankAccount;

    AbstractSupplier(String name, String address, String bankAccount) {
        this.name = name;
        this.address = address;
        this.bankAccount = bankAccount;
    }
}
