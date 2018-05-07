package BehavioralPatterns.ChainOfResponsobilities;

class FoodSupplier extends OrderHandler {
    FoodSupplier(OrderType handlerType, String name) {
        super(handlerType, name);
    }

    @Override
    void handleOrder(Order order) {
        System.out.println(getClass().getSimpleName() + ". Поставщик: " + getName() + ": обработал заказ номер: " + order.getId());
    }
}
