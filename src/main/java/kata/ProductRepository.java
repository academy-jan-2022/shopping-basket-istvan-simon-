package kata;


import java.util.HashMap;

public class ProductRepository {

    private final HashMap<ProductID, Product> storage;

    public ProductRepository(HashMap<ProductID, Product> storage) {
        this.storage = storage;
    }


    public Product getProduct(){
        return new Product(new ProductID(1), "Breaking Bad", new Money(7));
    }

    public void createProduct(ProductID productID, String productTitle, int productPrice) {
        storage.put(productID, new Product(productID, productTitle, new Money(productPrice)));
    }
}
