package hepsiburada;

import org.testng.annotations.Test;

/**
 * @author sercansensulun on 29.03.2020.
 */
public class Test002 extends HepsiburadaAbstractTest {

    @Test
    public void test() {
        addTwoItemsFromDifferentVendorsToCart();
    }
}
