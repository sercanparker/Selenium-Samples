package interfaces.bbc;

import concrete.TestStep;
import pages.bbc.HomePage;
import pages.bbc.MusicPage;
import pages.bbc.SearchPage;
import pages.bbc.SportPage;

/**
 * @author sercansensulun on 4.03.2020.
 */
public interface IHomePage {

    SportPage clickSportPage();
    void clickMore();
    MusicPage clickMusicPage();
    TestStep enterSearchInputArea(String searchKeyword);
    SearchPage clickSearchButton();
    HomePage clickHomePage();

}
