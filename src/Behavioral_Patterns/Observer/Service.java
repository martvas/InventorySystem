package Behavioral_Patterns.Observer;

class Service implements OrderObserver {
    private String name;

    Service(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println("Сервис " + name + " теперь знает о заказе");
    }
}
