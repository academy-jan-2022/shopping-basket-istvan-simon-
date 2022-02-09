package kata;

import java.util.List;

public interface ShoppingBasketService {
    void addItem(UserID userId, ProductID product, int quantity);
    String basketFor(UserID userId);
}
