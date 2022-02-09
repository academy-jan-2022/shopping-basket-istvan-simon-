package kata;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ShoppingBasketShould {

    @Test void
    add_a_item_into_the_basket (){
        UserID user = new UserID(1);
        ProductID productID = new ProductID(1);
        Product product = new Product(productID, "The Hobbit", new Money(5));
        int quantity = 5;
        var repositoryMock = mock(ShoppingRepositoryService.class);
        ShoppingBasket basket = new ShoppingBasket(repositoryMock);
        basket.addItem(user, product, quantity);
        verify(repositoryMock).addPurchase(product, quantity);
    }
}
