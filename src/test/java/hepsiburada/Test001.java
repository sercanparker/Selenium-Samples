package hepsiburada;

import concrete.TestStep;
import constants.TestSettingConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.hepsiburada.LoginPage;
import pages.hepsiburada.MainPage;

/**
 * @author sercansensulun on 29.03.2020.
 */
public class Test001 extends HepsiburadaAbstractTest{

    @Test(priority = 1)
    public void login(){

        MainPage mainPage = getMainPage();
        LoginPage loginPage = mainPage.clickLoginPage();
        Assert.assertNotNull(loginPage);

        TestStep clickLoginRadioButtonStep = loginPage.clickLoginRadioButton();
        Assert.assertTrue(clickLoginRadioButtonStep.isSuccess());

        TestStep enterEmailStep = loginPage.enterEmail(TestSettingConstants.HEPSIBURADA_EMAIL);
        Assert.assertTrue(enterEmailStep.isSuccess());

        TestStep enterPasswordStep = loginPage.enterPassword(TestSettingConstants.HEPSIBURADA_PASSWORD);
        Assert.assertTrue(enterPasswordStep.isSuccess());

        MainPage mainPageAfterLogin = loginPage.clickLoginButton();
        mainPageAfterLogin.checkLoginSuccess();


    }

    @Test(priority = 2)
    public void addCart() {
        addTwoItemsFromDifferentVendorsToCart();
    }

    @Test(priority = 3)
    public void logout(){

        MainPage mainPage = getMainPage();
        mainPage.logout();
    }
}
