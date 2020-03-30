package constants.hepsiburada;

/**
 * @author sercansensulun on 30.03.2020.
 */
public class ShoppingCartPageXpaths {
    public static final String ITEM_LIST = "//form[@id=\"form-item-list\"]//li";
    public static final String N_TH_ITEM_TITLE = "(//form[@id=\"form-item-list\"]//li)[%d]//*[@class=\"product-name\"]";
    public static final String N_TH_ITEM_VENDOR = "(//form[@id=\"form-item-list\"]//li)[%d]//*[@class=\"merchant\"]//a";
    public static final String N_TH_ITEM_REMOVE_BUTTON = "(//form[@id=\"form-item-list\"]//li)[%d]//*[text()=\"Sil\"]";
}
