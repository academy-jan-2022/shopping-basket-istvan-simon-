package kata;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingRepositoryInMemoryShould {

    @Test void
    add_an_item(){
        UserID userID = new UserID(1);
        ProductID productID = new ProductID(1);
        int quantity = 5;
        ShoppingRepository repo = new ShoppingRepositoryInMemory(new DateProvider());
        repo.addPurchase(userID, productID, quantity);
        var result = repo.getFor(userID);
        var creationDate = new DateProvider().getDate();
        assertEquals(
            List.of(new Purchase(productID,quantity, creationDate)),
            result
        );
    }
    @Test void
    add_two_items(){
        UserID userID = new UserID(1);
        ProductID productID = new ProductID(1);
        ProductID secondproductID = new ProductID(2);
        int quantity = 5;
        ShoppingRepository repo = new ShoppingRepositoryInMemory(new DateProvider());
        repo.addPurchase(userID, productID, quantity);
        repo.addPurchase(userID, secondproductID, quantity);
        var result = repo.getFor(userID);
        var creationDate = new DateProvider().getDate();
        assertEquals(
            List.of(new Purchase(productID,quantity, creationDate), new Purchase(secondproductID,quantity, creationDate)),
            result
        );
    }
    @Test void
    add_an_item_twice(){
        UserID userID = new UserID(1);
        ProductID productID = new ProductID(1);
        int quantity = 5;
        ShoppingRepository repo = new ShoppingRepositoryInMemory(new DateProvider());
        repo.addPurchase(userID, productID, quantity);
        repo.addPurchase(userID, productID, quantity);
        var result = repo.getFor(userID);
        var creationDate = new DateProvider().getDate();
        assertEquals(
            List.of(new Purchase(productID,quantity+quantity, creationDate)),
            result
        );
    }

    @Test void
    add_an_item_twice_plus_another_item(){
        UserID userID = new UserID(1);
        ProductID productID = new ProductID(1);
        ProductID secondProductID = new ProductID(2);
        int quantity = 5;
        ShoppingRepository repo = new ShoppingRepositoryInMemory(new DateProvider());
        repo.addPurchase(userID, productID, quantity);
        repo.addPurchase(userID, productID, quantity);
        repo.addPurchase(userID, secondProductID, quantity);
        var result = repo.getFor(userID);
        var creationDate = new DateProvider().getDate();
        assertEquals(
            List.of(new Purchase(productID,quantity+quantity, creationDate), new Purchase(secondProductID, quantity,
                creationDate)),
            result
        );
    }
}
