package kata;

import java.util.List;

public class ShoppingBasket implements ShoppingBasketService {


    @Override
    public void addItem(UserID userId, Product product, int quantity) {
         throw new UnsupportedOperationException();
    }

    @Override
    public String basketFor(UserID userId) {
        throw new UnsupportedOperationException();
    }
}
