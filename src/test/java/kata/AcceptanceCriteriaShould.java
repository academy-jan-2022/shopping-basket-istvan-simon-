package kata;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcceptanceCriteriaShould {

    /*
    Given I add 2 units of "The Hobbit" to my shopping basket
    And I add 5 units of "Breaking Bad"
    When I check the content of my shopping basket
    Then it should contain the following infomation:
        - Creation date (of the shopping basket)
    - 2 x The Hobbit   // 2 x 5.00 = £10.00
    - 5 x Breaking Bad // 5 x 7.00 = £35.00
    - Total: £45.00
    */

    @Test void
    confirm_this_order(){

        var user = new UserID(1);
        var hobbitID = new ProductID(1);
        var hobbitProduct = new Product(hobbitID, "The Hobbit", new Money(5));
        var breakingBadID = new ProductID(2);
        var breakingBadProduct = new Product(breakingBadID, "Breaking bad", new Money(7));
        var basket = new ShoppingBasket();
        basket.addItem(user, hobbitProduct, 2);
        basket.addItem(user, breakingBadProduct, 5);
        var result = basket.basketFor(user);

        String expectedOutput = " - Creation date (of the shopping basket)\n" +
            "    - 2 x The Hobbit   // 2 x 5.00 = £10.00\n" +
            "    - 5 x Breaking Bad // 5 x 7.00 = £35.00\n" +
            "    - Total: £45.00";
        assertEquals(expectedOutput, result);
    }
}
