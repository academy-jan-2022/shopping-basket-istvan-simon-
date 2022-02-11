package kata;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

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
        String hobbitTitle = "The Hobbit";
        int hobbitPrice = 5;
        var breakingBadID = new ProductID(2);
        String breakingBadTitle = "Breaking Bad";
        int breakingBadPrice = 7;
        ProductRepository productRepository = new ProductRepository(new HashMap<ProductID, Product>());
        productRepository.createProduct(hobbitID, hobbitTitle, hobbitPrice);
        productRepository.createProduct(breakingBadID, breakingBadTitle, breakingBadPrice);
        var basket = new ShoppingBasket(new ShoppingRepositoryInMemory(new DateProvider()),productRepository);
        basket.addItem(userID, hobbitID, 2);
        basket.addItem(userID, breakingBadID, 5);
        var result = basket.basketFor(userID);
        var creationDate = new DateProvider().getDate();

        String expectedOutput = " - Creation date " + creationDate +  "\n" +
            "    - 2 x The Hobbit // 2 x 5.00 = £10.00\n" +
            "    - 5 x Breaking Bad // 5 x 7.00 = £35.00\n" +
            "    - Total: £45.00";
        assertEquals(expectedOutput, result);
    }

   /* [BASKET CREATED]: Created[<"YYYY-07-12">], User[]
    [ITEM ADDED TO SHOPPING CART]: Added[<"YYYY-07-12">], User[], Product[], Quantity[], Price[<£12.00>]*/
    @Test void
    scenario_two(){
        var output = new ByteArrayOutputStream(); System.setOut(new PrintStream(output));
        var userID = new UserID(1);
        var hobbitID = new ProductID(1);
        String hobbitTitle = "The Hobbit";
        int hobbitPrice = 5;
        var breakingBadID = new ProductID(2);
        String breakingBadTitle = "Breaking Bad";
        int breakingBadPrice = 7;
        ProductRepository productRepository = new ProductRepository(new HashMap<ProductID, Product>());
        productRepository.createProduct(hobbitID, hobbitTitle, hobbitPrice);
        productRepository.createProduct(breakingBadID, breakingBadTitle, breakingBadPrice);
        var basket = new ShoppingBasket(new ShoppingRepositoryInMemory(new DateProvider()),productRepository);
        basket.addItem(userID, hobbitID, 2);
        basket.addItem(userID, breakingBadID, 5);
        var expected = "[BASKET CREATED]: Created[<\"11-02-2022\">], UserID[user=1] \n" +
            "[ITEM ADDED TO SHOPPING CART]: Added[<\"11-02-2022\">], UserID[user=1], ProductID[productID=1], 2, Price[<£5.00>]\n" +
            "[ITEM ADDED TO SHOPPING CART]: Added[<\"11-02-2022\">], UserID[user=1], ProductID[productID=2], 5, Price[<£7.00>]\n";
        var result = output.toString();
        assertEquals(expected, result);

    }

}
