package kata;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

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
        var repo = new HashMap<ProductID, Product>();

        var productRepository = new ProductRepository(repo);
        String output = " - Creation date "
            +creationDate
            +"\n"
            +"    - ";
            var itemPrice = productRepository.getProduct(list.get(0).productID()).price().amount();
            var itemAmount = list.get(0).amount();
            var itemTotal = itemPrice * itemAmount;
            var total = itemTotal;
            output += list.get(0).amount()
            +" x "
            + productRepository.getProduct(list.get(0).productID()).title()
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
