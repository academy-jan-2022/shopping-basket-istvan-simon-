package kata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingRepositoryInMemory implements ShoppingRepository {
    private final HashMap<UserID, List<Purchase>> storage = new HashMap<UserID,List<Purchase>>();
    private final DateProvider dateProvider;

    public ShoppingRepositoryInMemory(DateProvider dateProvider) {
        this.dateProvider = dateProvider;
    }
/*[BASKET CREATED]: Created[<"YYYY-07-12">], User[]*/
/*[ITEM ADDED TO SHOPPING CART]: Added[<"YYYY-07-12">], User[], Product[], Quantity[], Price[<£12.00>]*/
    @Override
    public void addPurchase(UserID userID,ProductID product, int quantity) {
        String currentDate= dateProvider.getDate();
        if (storage.get(userID) == null){

            storage.put(userID,List.of(new Purchase(product, quantity, currentDate)));
            System.out.print("[BASKET CREATED]: Created[<\""+currentDate+"\">], "+userID+" \n");
            System.out.print("[ITEM ADDED TO SHOPPING CART]: Added[<\""+currentDate+"\">], "+userID+", "+product+", "+quantity+", NOT KNOWN\n");

            return;
        }

        List<Purchase> list = new ArrayList<>(storage.get(userID));

        for (int i=0; i < list.size(); i++) {
            if (list.get(i).productID() == product) {
                int currentAmount = list.get(i).amount();
                var actualCreationDate = list.get(i).creationDate();
                list.set(i, new Purchase(product, (currentAmount + quantity), actualCreationDate));
                storage.put(userID, list);
                System.out.print("[ITEM ADDED TO SHOPPING CART]: Added[<\""+currentDate+"\">], "+userID+", "+product+", "+quantity+", NOT KNOWN\n");
                return;
            }
        }

        list.add(new Purchase(product, quantity, dateProvider.getDate()));
        storage.put(userID, list);
        System.out.print("[ITEM ADDED TO SHOPPING CART]: Added[<\""+currentDate+"\">], "+userID+", "+product+", "+quantity+", NOT KNOWN\n");
    }
    @Override
    public List<Purchase> getFor(UserID userID) {
        return storage.get(userID);
    }

    @Override
    public String getDate(UserID userID) {
        var userBasket = getFor(userID);
        var result = userBasket.get(0).creationDate();

        return result;
    }

}
