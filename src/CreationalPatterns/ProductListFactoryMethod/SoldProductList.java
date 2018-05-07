package CreationalPatterns.ProductListFactoryMethod;

import java.util.Date;

class SoldProductList extends ListOfConcreteProducts {
    SoldProductList(Date date) {
        super(date);
    }
}
