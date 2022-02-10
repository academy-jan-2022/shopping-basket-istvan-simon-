package kata;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductRepositoryShould {

    @Test void
    create_new_item_and_read(){
        var expected = new HashMap<ProductID, Product>();
        var repo = new ProductRepository(expected);
        var productID = new ProductID(1);
        var title = "The hobbit";
        var productPrice = 5;

        repo.createProduct(productID, title, productPrice);

        var expectedProduct = expected.get(productID);

        assertEquals(expectedProduct, new Product(productID, title, new Money(productPrice)));
    }

}
