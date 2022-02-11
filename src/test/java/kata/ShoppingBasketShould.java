package kata;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ShoppingBasketShould {

    @Test void
    add_a_item_into_the_basket (){
        UserID userID = new UserID(1);
        ProductID productID = new ProductID(1);
        int quantity = 5;
        var repositoryMock = mock(ShoppingRepository.class);
        ShoppingBasket basket = new ShoppingBasket(repositoryMock, new ProductRepository(new HashMap<ProductID, Product>()));
        basket.addItem(userID, productID, quantity);
        verify(repositoryMock).addPurchase(userID,productID, quantity);
    }

    @Test void
    return_contents_of_basket_for_specified_user() {
        UserID userID = new UserID(1);
        ProductID productID = new ProductID(1);
        String productTitle = "Breaking Bad";
        int productPrice = 7;
        int quantity = 5;
        ProductRepository productRepository = new ProductRepository(new HashMap<ProductID, Product>());
        productRepository.createProduct(productID, productTitle, productPrice);
        ShoppingBasket basket = new ShoppingBasket(new ShoppingRepositoryInMemory(new DateProvider()),productRepository);
        basket.addItem(userID, productID, quantity);
        var expected = " - Creation date 11-02-2022\n" +
            "    - 5 x Breaking Bad // 5 x 7.00 = £35.00\n" +
            "    - Total: £35.00";
        var result = basket.basketFor(userID);

        assertEquals(expected, result);

    }
    @Test void
    return_two_items_content_for_specified_user() {
        UserID userID = new UserID(1);
        ProductID productID = new ProductID(1);
        String productTitle =  "Breaking Bad";
        int productPrice = 7;
        ProductID secondProductID = new ProductID(2);
        String secondProductTitle =  "The hobbit";
        int secondProductPrice = 5;
        var repositoryMock = mock(ProductRepository.class);

        repositoryMock.createProduct(productID, productTitle,productPrice);
        repositoryMock.createProduct(secondProductID, secondProductTitle,secondProductPrice);
        int quantity = 5;

        ProductRepository productRepository = new ProductRepository(new HashMap<ProductID, Product>());
        productRepository.createProduct(productID, productTitle, productPrice);
        productRepository.createProduct(secondProductID, secondProductTitle, secondProductPrice);
        ShoppingBasket basket = new ShoppingBasket(new ShoppingRepositoryInMemory(new DateProvider()),productRepository );
        basket.addItem(userID, productID, quantity);
        basket.addItem(userID, secondProductID, quantity);

        var expected = " - Creation date 11-02-2022\n" +
            "    - 5 x Breaking Bad // 5 x 7.00 = £35.00\n" +
            "    - 5 x The hobbit // 5 x 5.00 = £25.00\n" +
            "    - Total: £60.00";
        var result = basket.basketFor(userID);

        assertEquals(expected, result);

    }

    @Test void
    return_basket_date_01_01_2022() throws ParseException {
        UserID userID = new UserID(1);
        ProductID productID = new ProductID(1);
        String productTitle = "Breaking Bad";
        int productPrice = 7;
        int quantity = 5;
        ProductRepository productRepository = new ProductRepository(new HashMap<ProductID, Product>());
        productRepository.createProduct(productID, productTitle, productPrice);
        DateProvider dateProvider = mock(DateProvider.class);
        when(dateProvider.getDate()).thenReturn("01-01-2022");
        ShoppingRepository shoppingRepository = new ShoppingRepositoryInMemory(dateProvider);
        shoppingRepository.addPurchase(userID,productID,quantity);

        String output = shoppingRepository.getDate(userID);
        String expected = "01-01-2022";
        assertEquals(expected, output);
    }

    @Test void
    return_basket_date_02_02_2022() throws ParseException {
        UserID userID = new UserID(2);
        ProductID productID = new ProductID(1);
        String productTitle = "Breaking Bad";
        int productPrice = 7;
        int quantity = 5;
        ProductRepository productRepository = new ProductRepository(new HashMap<ProductID, Product>());
        productRepository.createProduct(productID, productTitle, productPrice);
        DateProvider dateProvider = mock(DateProvider.class);
        when(dateProvider.getDate()).thenReturn("02-02-2022");
        ShoppingRepository shoppingRepository = new ShoppingRepositoryInMemory(dateProvider);
        shoppingRepository.addPurchase(userID,productID,quantity);

        String output = shoppingRepository.getDate(userID);
        String expected = "02-02-2022";
        assertEquals(expected, output);
    }

}
