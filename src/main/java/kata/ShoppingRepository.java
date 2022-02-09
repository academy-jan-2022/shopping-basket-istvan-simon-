package kata;

import java.util.List;

public interface ShoppingRepository {
    void addPurchase(UserID userID, ProductID product, int quantity);

    List<Purchase> getFor(UserID userID);
}
