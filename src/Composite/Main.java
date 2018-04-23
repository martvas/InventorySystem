package Composite;

public class Main {
    public static void main(String[] args) {
        Supplier lowiczanka = new AlcoholSupplier("Lowiczanka", "Den Haag", "055ing");
        Supplier almos = new AlcoholSupplier("Almos", "Rotterdam", "uig4560");

        Supplier mastermedia = new ProductSupplier("Mastermedia", "Utrecht", "415ddd");
        Supplier htm = new ProductSupplier("HTM groep", "Krakow", "123fff");
        Supplier lemonex = new ProductSupplier("Lemonex", "Poznan", "456dhh");

        Supplier phu = new MeatSupplier("PHU Sandra", "Gdansk", "123ghhj");
        Supplier tjLogistic = new MeatSupplier("TJ Logistic", "Amsterdam", "4654ddd");

        Composite allSuppliersComposite = new Composite();

        Composite alcoholComposite = new Composite();
        Composite productComposite = new Composite();
        Composite meatComposite = new Composite();

        alcoholComposite.addComponent(lowiczanka);
        alcoholComposite.addComponent(almos);

        productComposite.addComponent(mastermedia);
        productComposite.addComponent(htm);
        productComposite.addComponent(lemonex);

        meatComposite.addComponent(phu);
        meatComposite.addComponent(tjLogistic);

        allSuppliersComposite.addComponent(alcoholComposite);
        allSuppliersComposite.addComponent(productComposite);
        allSuppliersComposite.addComponent(meatComposite);

        allSuppliersComposite.showInfo();
    }
}
