package Composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Supplier {
    private List<Supplier> components = new ArrayList<>();

    void addComponent(Supplier s) {
        components.add(s);
    }

    public void removeComponent(Supplier s) {
        components.remove(s);
    }

    @Override
    public void showInfo() {
        for (Supplier component : components) {
            component.showInfo();
        }
    }
}
