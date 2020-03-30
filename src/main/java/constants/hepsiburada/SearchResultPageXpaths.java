package constants.hepsiburada;

/**
 * @author sercansensulun on 30.03.2020.
 */
public class SearchResultPageXpaths {
    public static final String VENDOR_LIST = "//li[@class=\"box-container satici\"]/ol/li";
    public static final String N_TH_VENDOR = "(//li[@class=\"box-container satici\"]/ol/li)[%d]";
    public static final String ADD_FIRST_ITEM_TO_CART_BUTTON = "(//button[@class=\"add-to-basket button small\"])[1]";
    public static final String REMOVE_FIRST_VENDOR_FILTER_BUTTON = "//li[@class=\"appliedFilter   \"]//a";
    public static final String FIRST_ITEM_NAME = "(//div[@class=\"product-detail\"])[1]//p";
}
