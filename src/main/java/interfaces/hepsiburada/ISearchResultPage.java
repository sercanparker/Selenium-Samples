package interfaces.hepsiburada;

import concrete.TestStep;

/**
 * @author sercansensulun on 29.03.2020.
 */
public interface ISearchResultPage {

    TestStep<Integer> getVendorCount();
    TestStep<String> getFirstItemName();
    TestStep<String> clickVendor(int order);
    TestStep addFirstItemToCart();
    TestStep removeVendorFilter();

}
