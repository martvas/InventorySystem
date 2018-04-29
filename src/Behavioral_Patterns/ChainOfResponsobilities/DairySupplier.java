package Behavioral_Patterns.ChainOfResponsobilities;

class DairySupplier extends OrderHandler {

    DairySupplier(OrderType handlerType, String name) {
        super(handlerType, name);
    }

    @Override
    void handleOrder(Order order) {
        System.out.println(getClass().getSimpleName() + ". Поставщик: " + getName() + ": обработал заказ номер: " + order.getId());
    }
}
