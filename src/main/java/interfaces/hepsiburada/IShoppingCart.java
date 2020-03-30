package interfaces.hepsiburada;

import concrete.TestStep;

/**
 * @author sercansensulun on 29.03.2020.
 */
public interface IShoppingCart {

    TestStep<Integer> getNumberOfItems();
    TestStep<String> getItemTitle(int order);
    TestStep<String> getVendorName(int order);
    TestStep removeItem(int order);

}
