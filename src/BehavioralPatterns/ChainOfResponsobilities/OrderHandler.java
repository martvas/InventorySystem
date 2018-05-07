package BehavioralPatterns.ChainOfResponsobilities;

abstract class OrderHandler {
    private OrderHandler nextOrderHandler;
    private OrderType handlerType;
    private String name;

    OrderHandler(OrderType handlerType, String name) {
        this.handlerType = handlerType;
        this.name = name;
    }

    void setNextOrderHandler(OrderHandler nextOrderHandler) {
        this.nextOrderHandler = nextOrderHandler;
    }

    void startHandle(Order order) {
        if (order.getOrderType() == handlerType) {
            handleOrder(order);
        } else if (nextOrderHandler != null) {
            nextOrderHandler.startHandle(order);
        } else
            System.out.println("Для заказа номер: " + order.getId() + ". Тип: " + order.getOrderType() + " - нет обработчика");
    }

    abstract void handleOrder(Order order);

    public String getName() {
        return name;
    }

}
