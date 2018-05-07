package BehavioralPatterns.ChainOfResponsobilities;

class AlcoholSupplier extends OrderHandler {
    AlcoholSupplier(OrderType handlerType, String name) {
        super(handlerType, name);
    }

    @Override
    void handleOrder(Order order) {
        System.out.println(getClass().getSimpleName() + ". Поставщик: " + getName() + ": обработал заказ номер: " + order.getId());
    }
}
