package kata;

import java.util.List;

public class ShoppingRepositoryInMemory implements ShoppingRepository {
    @Override
    public void addPurchase(UserID userID,ProductID product, int quantity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Purchase> getFor(UserID userID) {
        throw new UnsupportedOperationException();
    }
}
