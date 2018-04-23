package Composite;

abstract class AbstractSupplier {
    String name;
    String address;
    String bankAccount;

    AbstractSupplier(String name, String address, String bankAccount) {
        this.name = name;
        this.address = address;
        this.bankAccount = bankAccount;
    }
}
