package kata;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        var list = shoppingRepository.getFor(userId);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        var creationDate = formatter.format(new Date());
        var productRepository = new ProductRepository();
        String output = " - Creation date "
            +creationDate
            +"\n"
            +"    - ";
            var itemPrice = productRepository.getProduct().price().amount();
            var itemAmount = list.get(0).amount();
            var itemTotal = itemPrice * itemAmount;
            var total = itemTotal;
            output += list.get(0).amount()
            +" x "
            + productRepository.getProduct().title()
            + " // "
            +itemAmount
            +" x "
            + String.format("%.2f",itemPrice)
            +" = £"
            +String.format("%.2f",itemTotal)
            +"\n";

            output += "    - Total: £"

            +String.format("%.2f",total);

        return  output;
    }
}
