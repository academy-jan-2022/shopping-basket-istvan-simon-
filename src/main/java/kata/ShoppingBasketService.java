package kata;

import java.util.List;

public interface ShoppingBasketService {
    void addItem(UserID userId, Product product, int quantity);
    String basketFor(UserID userId);
}
