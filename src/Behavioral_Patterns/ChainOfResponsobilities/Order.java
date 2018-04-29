package Behavioral_Patterns.ChainOfResponsobilities;

class Order {
    private int id;
    private OrderType orderType;

    Order(int id, OrderType orderType) {
        this.id = id;
        this.orderType = orderType;
    }

    int getId() {
        return id;
    }

    OrderType getOrderType() {
        return orderType;
    }
}
