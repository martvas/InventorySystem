package MVC.View;

import javax.swing.*;

public interface View<Controller> {
    Controller getController();

    void setController(Controller controller);

    JComponent getView();
}
