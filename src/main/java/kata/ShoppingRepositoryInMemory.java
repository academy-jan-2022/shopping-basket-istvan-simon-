package kata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingRepositoryInMemory implements ShoppingRepository {
    private HashMap<UserID, List<Purchase>> storage = new HashMap<UserID,List<Purchase>>();
    @Override
    public void addPurchase(UserID userID,ProductID product, int quantity) {
        if (storage.get(userID) == null){
            storage.put(userID,List.of(new Purchase(product, quantity)));
            return;
        }
        List<Purchase> oldList = storage.get(userID);
        List<Purchase> list= new ArrayList<>();
        list.addAll(oldList);
        list.add(new Purchase(product, quantity));

        storage.put(userID, list);
    }
    @Override
    public List<Purchase> getFor(UserID userID) {
        return storage.get(userID);
    }
}
