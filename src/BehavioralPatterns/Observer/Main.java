package BehavioralPatterns.Observer;

public class Main {
    public static void main(String[] args) {
        OrderObserver supplier = new Supplier("ХТМ");
        OrderObserver manager = new Manager("Аетон");
        OrderObserver ohrana = new Service("Охрана");

        OrderObservable order = new Order();
        order.addOserver(supplier);
        order.addOserver(manager);
        order.addOserver(ohrana);

        order.notifyObservers();
    }
}
