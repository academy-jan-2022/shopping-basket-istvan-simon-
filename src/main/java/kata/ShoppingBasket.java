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
            //TODO Get product information by productID and use it on the output
            output.append("    - ");
            output.append(purchase.amount());
            output.append(" x ");
            output.append("mabe based on"+purchase.productID().product());
            output.append("   // ");
            output.append(purchase.amount());
            output.append(" x ");
            output.append("----");
            output.append(" = £");
            output.append("----");
            output.append("\n");
        }

        output.append("Total: £");
        output.append("----");
        return output.toString();
    }
}
