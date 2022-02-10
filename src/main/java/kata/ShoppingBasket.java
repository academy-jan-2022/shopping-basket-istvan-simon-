package kata;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class ShoppingBasket implements ShoppingBasketService{
    private final ShoppingRepository shoppingRepository;
    private ProductRepository productRepository;

    public ShoppingBasket(ShoppingRepository shoppingRepository, ProductRepository productRepository ) {
        this.shoppingRepository = shoppingRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void addItem(UserID userId, ProductID product, int quantity) {
        shoppingRepository.addPurchase(userId,product,quantity);
    }

    @Override
    public String basketFor(UserID userId) {
        var list = shoppingRepository.getFor(userId);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        var creationDate = formatter.format(new Date());
        String output = " - Creation date "
            +creationDate
            +"\n";
        float finalTotal = 0;
        for (int i = 0; i < list.size(); i++) {
            output += "    - ";
            var itemPrice = productRepository.getProduct(list.get(i).productID()).price().amount();
            var itemAmount = list.get(i).amount();
            var itemTotal = itemPrice * itemAmount;
            var total = itemTotal;
            output += list.get(i).amount()
                + " x "
                + productRepository.getProduct(list.get(i).productID()).title()
                + " // "
                + itemAmount
                + " x "
                + String.format("%.2f", itemPrice)
                + " = £"
                + String.format("%.2f", itemTotal)
                + "\n";
            finalTotal += total;
        }
            output += "    - Total: £"

            +String.format("%.2f",finalTotal);

        return  output;
    }
}
