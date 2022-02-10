package kata;


public class ProductRepository {

    public Product getProduct(){
        return new Product(new ProductID(1), "Breaking Bad", new Money(7));
    }

    public void createProduct(ProductID productID, String productTitle, int productPrice) {
        throw new UnsupportedOperationException();
    }
}
