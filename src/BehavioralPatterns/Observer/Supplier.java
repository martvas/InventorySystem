package BehavioralPatterns.Observer;

public class Supplier implements OrderObserver {
    private String name;

    Supplier(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println("Поставщик " + name + ": начал обрабатывать заказ");
    }
}
