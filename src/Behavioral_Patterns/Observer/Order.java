package Behavioral_Patterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class Order implements OrderObservable {
    private List<OrderObserver> observerList;

    Order() {
        observerList = new ArrayList<>();
    }

    @Override
    public void addOserver(OrderObserver orderObserver) {
        observerList.add(orderObserver);
    }

    @Override
    public void deleteObserver(OrderObserver orderObserver) {
        observerList.remove(orderObserver);
    }

    @Override
    public void notifyObservers() {
        for (OrderObserver orderObserver : observerList) {
            orderObserver.update();
        }
    }
}
