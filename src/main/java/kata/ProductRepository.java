package kata;


import java.util.HashMap;

public class ProductRepository {

    private final HashMap<ProductID, Product> storage;

    public ProductRepository(HashMap<ProductID, Product> storage) {
        this.storage = storage;
    }


    public Product getProduct(ProductID productID){
        return storage.get(productID);
    }

    public void createProduct(ProductID productID, String productTitle, int productPrice) {
        storage.put(productID, new Product(productID, productTitle, new Money(productPrice)));
    }
}
