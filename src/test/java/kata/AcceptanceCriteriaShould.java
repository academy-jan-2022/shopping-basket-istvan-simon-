package kata;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        String expectedOutput= "- Creation date 09-02-2022\n" +
            "- 2 x The Hobbit   // 2 x 5.00 = £10.00\n" +
            "- 5 x Breaking Bad // 5 x 7.00 = £35.00\n" +
            "- Total: £45.00";


        ShoppingBasket basket = new ShoppingBasket();
       basket.addItem(new UserID(1),new ProductID(1), 2);
       basket.addItem(new UserID(1),new ProductID(2), 5);
       basket.basketFor(new UserID(1));

        assertEquals(expectedOutput, output.toString());
    }
}
