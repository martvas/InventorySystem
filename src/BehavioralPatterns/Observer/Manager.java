package BehavioralPatterns.Observer;

public class Manager implements OrderObserver {
    private String name;

    Manager(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println("Менеджера " + name + " известили о заказе");
    }
}
