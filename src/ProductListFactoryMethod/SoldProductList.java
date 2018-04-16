package ProductListFactoryMethod;

import java.util.Date;

public class SoldProductList extends ListOfConcreteProducts {
    SoldProductList(Date date) {
        super(date);
    }
}
