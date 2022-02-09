package kata;

public class ShoppingBasket implements ShoppingBasketService {


    private final ShoppingRepository shoppingRepository;

    public ShoppingBasket(ShoppingRepository shoppingRepository) {
        this.shoppingRepository = shoppingRepository;
    }

    @Override
    public void addItem(UserID userId, ProductID product, int quantity) {

        shoppingRepository.addPurchase(product,quantity);
    }

    @Override
    public String basketFor(UserID userId) {
        throw new UnsupportedOperationException();
    }
}
