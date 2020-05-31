package interfaces.n11;

import concrete.TestStep;

/**
 * @author sercansensulun on 30.05.2020.
 */
public interface IShoppingCartPage {
    TestStep<String> getItemName(int order);
    TestStep<Integer> getItemPrice(int order);
    TestStep incrementItemCount(int order);
    TestStep<Integer> getItemCount(int order);
    TestStep clickDeleteItemButton(int order);
    TestStep<Integer> getDistinctItemCount();
    TestStep isCartEmpty();
}
