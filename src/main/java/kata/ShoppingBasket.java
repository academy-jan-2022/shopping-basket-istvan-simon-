package kata;

public class ShoppingBasket implements ShoppingBasketService {


    public ShoppingBasket(ShoppingRepositoryService shoppingRepository) {
    }

    @Override
    public void addItem(UserID userId, Product product, int quantity) {
         throw new UnsupportedOperationException();
    }

    @Override
    public String basketFor(UserID userId) {
        throw new UnsupportedOperationException();
    }
}
