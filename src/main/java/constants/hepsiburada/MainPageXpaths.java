package constants.hepsiburada;

/**
 * @author sercansensulun on 29.03.2020.
 */
public class MainPageXpaths {
    public static final String SEARCH_INPUT_AREA = "//*[@id=\"SearchBoxOld\"]//*[@type=\"text\"]";
    public static final String SEARCH_BUTTON = "//*[@id=\"SearchBoxOld\"]//*[@class=\"SearchBoxOld-buttonContainer\"]";
    public static final String MY_CART_BUTTON = "//a[@href=\"https://www.hepsiburada.com/ayagina-gelsin/sepetim\"]";
    public static final String BIG_LOGIN_BUTTON = "//*[@id=\"old/header\"]//span[contains(text(), \"Giriş Yap\")]";
    public static final String LOGIN_ITEM = "//*[@id=\"login\"]";
    public static final String MY_ACCOUNT_TITLE = "//a[@title=\"Hesabım\"]//span[text() = \"Hesabım\"]";
    public static final String LOGOUT_ITEM = "//*[@id=\"old/header_182\"]//*[text() = \"Çıkış Yap\"]";
}
