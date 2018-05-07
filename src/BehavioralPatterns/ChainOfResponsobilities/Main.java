package BehavioralPatterns.ChainOfResponsobilities;

public class Main {
    public static void main(String[] args) {
        OrderHandler mastermedia = new FoodSupplier(OrderType.FOOD, "Mastermedia");
        OrderHandler molochnik = new DairySupplier(OrderType.DAIRY, "Веселый молочник");
        OrderHandler lowiczanka = new AlcoholSupplier(OrderType.ALCOHOL, "Алко Ловишанка");

        mastermedia.setNextOrderHandler(molochnik);
        molochnik.setNextOrderHandler(lowiczanka);

        Order dairyOrder = new Order(123, OrderType.DAIRY);
        Order alcoholOrder = new Order(789, OrderType.ALCOHOL);
        Order frozenOrder = new Order(456, OrderType.FROZEN_PRODUCTS);

        mastermedia.startHandle(dairyOrder);
        mastermedia.startHandle(alcoholOrder);
        mastermedia.startHandle(frozenOrder);
    }
}
