package kata;

import java.util.List;

public interface ShoppingBasketService {
    void addItem(UserID userId, Product product, int quantity);
    List<Purchase> basketFor(UserID userId);
}
