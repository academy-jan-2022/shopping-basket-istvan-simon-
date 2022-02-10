package kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ShoppingBasketShould {

    @Test void
    add_a_item_into_the_basket (){
        UserID userID = new UserID(1);
        ProductID productID = new ProductID(1);
        Product product = new Product(productID, "The Hobbit", new Money(5));
        int quantity = 5;
        var repositoryMock = mock(ShoppingRepository.class);
        ShoppingBasket basket = new ShoppingBasket(repositoryMock);
        basket.addItem(userID, productID, quantity);
        verify(repositoryMock).addPurchase(userID,productID, quantity);
    }

    @Test void
    return_contents_of_basket_for_specified_user() {
        UserID userID = new UserID(1);
        ProductID productID = new ProductID(1);
        int quantity = 5;
        ShoppingBasket basket = new ShoppingBasket(new ShoppingRepositoryInMemory());
        basket.addItem(userID, productID, quantity);
        var expected = " - Creation date (of the shopping basket)\n" +
            "    - 5 x Breaking Bad // 5 x 7.00 = £35.00\n" +
            "    - Total: £45.00";
        var result = basket.basketFor(userID);

        assertEquals(expected, result);

    }

}
