package interfaces.n11;

import concrete.TestStep;
import pages.n11.ItemDetailPage;

/**
 * @author sercansensulun on 30.05.2020.
 */
public interface ISearchPage {

    TestStep clickNthSearchPage(int n);
    TestStep<Integer> getActiveSearchPageNumber();
    TestStep<ItemDetailPage> clickRandomItem(int max);

}
