package kata;

public interface ShoppingBasketService {
    void addItem(UserID userId, ProductID productId, int quantity);
    void basketFor(UserID userId);
}
