package interfaces.n11;

import concrete.TestStep;
import pages.n11.ShoppingCartPage;

/**
 * @author sercansensulun on 30.05.2020.
 */
public interface IItemDetailPage {

    TestStep writeItemDetailsToTextFile();
    TestStep<String> getItemName();
    TestStep<Integer> getItemPrice();
    TestStep clickAddToShoppingCartButton();
    TestStep<ShoppingCartPage> clickShoppingCartButton();

}
