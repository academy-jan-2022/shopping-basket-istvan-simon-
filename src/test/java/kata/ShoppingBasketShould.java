package kata;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ShoppingBasketShould {

    @Test void
    add_a_item_into_the_basket (){

        var basketMock = mock(ShoppingBasketService.class);
        UserID user = new UserID(1);
        ProductID product = new ProductID(1);
        basketMock.addItem( user, product,1);
        verify(basketMock).addItem(user, product,1);
    }
}
