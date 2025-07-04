import models.products.Cheese;
import models.products.Biscuits;
import models.products.TV;
import models.products.MobileScratchCard;
import models.*;
import services.CheckoutService;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

        // Create products
        Cheese cheese = new Cheese(100, 10, 200, LocalDate.now().plusDays(5));
        Biscuits biscuits = new Biscuits(150, 5, 700, LocalDate.now().plusDays(2));
        TV tv = new TV(300, 5, 4000); // 4kg
        MobileScratchCard scratchCard = new MobileScratchCard(50, 20);

        // Create customer
        Customer customer = new Customer("Mohamed Yasser", 2000);

        // Create cart and add items
        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(tv, 3);
        cart.add(scratchCard, 1);

        // Checkout
        CheckoutService.checkout(customer, cart);
    }
}
