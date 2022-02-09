package kata;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
            List.of(new Purchase(userID,productID,quantity)),
            result
        );
    }
}
