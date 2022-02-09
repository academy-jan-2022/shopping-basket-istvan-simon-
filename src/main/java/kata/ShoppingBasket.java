package kata;

import jdk.jshell.spi.ExecutionControl;

public class ShoppingBasket implements ShoppingBasketService {

    @Override
    public void addItem(UserID userId, ProductID productId, int quantity) {
         throw new UnsupportedOperationException();
    }

    @Override
    public void basketFor(UserID userId) {
        throw new UnsupportedOperationException();
    }
}
