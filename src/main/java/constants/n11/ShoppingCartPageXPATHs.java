package constants.n11;

/**
 * @author sercansensulun on 30.05.2020.
 */
public class ShoppingCartPageXPATHs {
    public static final String SELECTED_ITEM_TABLE = "//table[@class=\"productGroup\"]";
    public static final String N_TH_ITEM_TITLE_LABEL = "(//table[@class=\"productGroup\"])[%d]//a[@class = \"prodDescription\"]";
    public static final String N_TH_ITEM_PRICE_LABEL = "(//table[@class=\"productGroup\"])[%d]//div[@class = \"priceArea\"]";
    public static final String N_TH_INCREMENT_BUTTON = "(//table[@class=\"productGroup\"])[%d]//span[@class = \"spinnerUp spinnerArrow\"]";
    public static final String N_TH_ITEM_COUNT_LABEL = "(//table[@class=\"productGroup\"])[%d]//div[@class = \"spinnerField \"]//input[@class=\"quantity\"]";
    public static final String N_TH_ITEM_DELETE_BUTTON = "(//table[@class=\"productGroup\"])[%d]//span[@class = \"removeProd svgIcon svgIcon_trash\"]";
    public static final String EMPTY_CHART_TITLE = "//div[@class=\"cartEmptyText\"]//h2";
}
