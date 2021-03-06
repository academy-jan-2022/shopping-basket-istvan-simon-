package kata;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductRepositoryShould {

    @Test void
    create_new_item(){
        var expected = new HashMap<ProductID, Product>();
        var repo = new ProductRepository(expected);
        var productID = new ProductID(1);
        var title = "The hobbit";
        var productPrice = 5;

        repo.createProduct(productID, title, productPrice);

        var expectedProduct = expected.get(productID);

        assertEquals(expectedProduct, new Product(productID, title, new Money(productPrice)));
    }

    @Test void
    create_two_new_items(){
        var expected = new HashMap<ProductID, Product>();
        var repo = new ProductRepository(expected);

        var productID = new ProductID(1);
        var title = "The hobbit";
        var productPrice = 5;
        var secondProductID = new ProductID(1);
        var secondTitle = "The hobbit";
        var secondProductPrice = 5;

        repo.createProduct(productID, title, productPrice);
        repo.createProduct(secondProductID, secondTitle, secondProductPrice);

        var expectedProduct = expected.get(productID);
        var secondExpectedProduct = expected.get(secondProductID);

        assertEquals(expectedProduct, new Product(productID, title, new Money(productPrice)));
        assertEquals(secondExpectedProduct, new Product(secondProductID, secondTitle, new Money(secondProductPrice)));
    }

    @Test void
    return_item_by_id(){
        var expected = new HashMap<ProductID, Product>();
        var repo = new ProductRepository(expected);
        var productID = new ProductID(1);
        var title = "The hobbit";
        var productPrice = 5;

        repo.createProduct(productID, title, productPrice);
        var outputProduct = repo.getProduct(productID);

        assertEquals(new Product(productID, title, new Money(productPrice)), outputProduct);
    }

}
