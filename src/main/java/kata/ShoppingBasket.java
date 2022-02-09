package kata;

public class ShoppingBasket implements ShoppingBasketService {


    private final ShoppingRepository shoppingRepository;

    public ShoppingBasket(ShoppingRepository shoppingRepository) {
        this.shoppingRepository = shoppingRepository;
    }

    @Override
    public void addItem(UserID userId, ProductID product, int quantity) {

        shoppingRepository.addPurchase(userId,product,quantity);
    }

    @Override
    public String basketFor(UserID userId) {
        StringBuilder output = new StringBuilder(" - Creation date (of the shopping basket)\n");
        var list = shoppingRepository.getFor(userId);
        for (Purchase purchase : list) {
            output.append("    - ");
            output.append(purchase.amount());
            output.append(" x ");
            output.append(purchase.productID().product());
            output.append("\n");
        }


        return output.toString();
    }
}
