package ProductListFactoryMethod;

import java.util.Date;

public class SpoiledProductList extends ListOfConcreteProducts {
    SpoiledProductList(Date date) {
        super(date);
    }
}
