package Behavioral_Patterns.Observer;

public interface OrderObservable {
    void addOserver(OrderObserver orderObserver);

    void deleteObserver(OrderObserver orderObserver);

    void notifyObservers();
}
