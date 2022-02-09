package kata;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

public class ShoppingRepositoryInMemory implements ShoppingRepository {
    private final HashMap<UserID,Purchase> storage = new HashMap<UserID,Purchase>();
    @Override
    public void addPurchase(UserID userID,ProductID product, int quantity) {
        storage.put(userID, new Purchase(product, quantity));
    }

    @Override
    public List<Purchase> getFor(UserID userID) {
        return List.of(storage.get(userID));
    }
}
