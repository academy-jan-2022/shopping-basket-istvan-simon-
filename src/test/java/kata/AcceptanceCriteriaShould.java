package kata;

import org.junit.jupiter.api.Test;

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

        var userID = new UserID(1);
        var hobbitID = new ProductID(1);
        var breakingBadID = new ProductID(2);
        var basket = new ShoppingBasket(new ShoppingRepositoryInMemory());
        basket.addItem(userID, hobbitID, 2);
        basket.addItem(userID, breakingBadID, 5);
        var result = basket.basketFor(userID);

        String expectedOutput = " - Creation date (of the shopping basket)\n" +
            "    - 2 x The Hobbit   // 2 x 5.00 = £10.00\n" +
            "    - 5 x Breaking Bad // 5 x 7.00 = £35.00\n" +
            "    - Total: £45.00";
        assertEquals(expectedOutput, result);
    }
}
