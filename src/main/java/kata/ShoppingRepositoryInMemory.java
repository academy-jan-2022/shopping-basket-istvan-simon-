package kata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingRepositoryInMemory implements ShoppingRepository {
    private final HashMap<UserID, List<Purchase>> storage = new HashMap<UserID,List<Purchase>>();
    @Override
    public void addPurchase(UserID userID,ProductID product, int quantity) {
        if (storage.get(userID) == null){
            storage.put(userID,List.of(new Purchase(product, quantity)));
            return;
        }

        List<Purchase> list = new ArrayList<>(storage.get(userID));

        for (int i=0; i < list.size(); i++) {
            if (list.get(i).productID() == product) {
                int currentAmount = list.get(i).amount();
                list.set(i, new Purchase(product, (currentAmount + quantity)));
                storage.put(userID, list);
                return;
            }
        }

        list.add(new Purchase(product, quantity));
        storage.put(userID, list);
    }
    @Override
    public List<Purchase> getFor(UserID userID) {
        return storage.get(userID);
    }
}
