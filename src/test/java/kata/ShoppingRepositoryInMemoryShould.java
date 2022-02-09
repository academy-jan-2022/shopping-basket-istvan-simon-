package kata;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingRepositoryInMemoryShould {

    @Test void
    add_an_item(){
        UserID userID = new UserID(1);
        ProductID productID = new ProductID(1);
        int quantity = 5;
        ShoppingRepository repo = new ShoppingRepositoryInMemory();
        repo.addPurchase(userID, productID, quantity);
        var result = repo.getFor(userID);
        assertEquals(
            List.of(new Purchase(productID,quantity)),
            result
        );
    }
    @Test void
    add_two_items(){
        UserID userID = new UserID(1);
        ProductID productID = new ProductID(1);
        ProductID secondproductID = new ProductID(2);
        int quantity = 5;
        ShoppingRepository repo = new ShoppingRepositoryInMemory();
        repo.addPurchase(userID, productID, quantity);
        repo.addPurchase(userID, secondproductID, quantity);
        var result = repo.getFor(userID);
        assertEquals(
            List.of(new Purchase(productID,quantity), new Purchase(secondproductID,quantity)),
            result
        );
    }
    @Test void
    add_an_item_twice(){
        UserID userID = new UserID(1);
        ProductID productID = new ProductID(1);
        int quantity = 5;
        ShoppingRepository repo = new ShoppingRepositoryInMemory();
        repo.addPurchase(userID, productID, quantity);
        repo.addPurchase(userID, productID, quantity);
        var result = repo.getFor(userID);
        assertEquals(
            List.of(new Purchase(productID,quantity+quantity)),
            result
        );
    }
}
