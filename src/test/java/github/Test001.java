package github;

import concrete.TestStep;
import constants.TestSettingConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.github.*;

/**
 * @author sercansensulun on 6.03.2020.
 */
public class Test001 extends GithubAbstractTest{

    @Test
    public void test001() throws InterruptedException {
        String newRepositoryName = "testrepo";

        HomePage homePage = getHomePage();
        NewRepositoryPage newRepositoryPage = homePage.clickNewRepositoryButton();
        Assert.assertNotNull(newRepositoryPage);

        TestStep enterRepositoryNameStep = newRepositoryPage.enterNewRepositoryName(newRepositoryName);
        Assert.assertTrue(enterRepositoryNameStep.isSuccess());

        CreatedNewRepositoryPage createdNewRepositoryPage = newRepositoryPage.clickCreateNewRepositoryButton();
        Assert.assertNotNull(createdNewRepositoryPage);

        TestStep clickSettingsStep = createdNewRepositoryPage.clickSettings();
        Assert.assertTrue(clickSettingsStep.isSuccess());

        TestStep clickOptionsStep = createdNewRepositoryPage.clickOptions();
        Assert.assertTrue(clickOptionsStep.isSuccess());

        createdNewRepositoryPage.sleep(3000);

        TestStep clickDeleteButtonStep = createdNewRepositoryPage.clickDeleteThisRepositoryButton();
        Assert.assertTrue(clickDeleteButtonStep.isSuccess());

        TestStep enterRepoNameForDeleteStep = createdNewRepositoryPage.enterRepositoryNameOnDeleteAttemptDialog(TestSettingConstants.GITHUB_USERNAME
                + "/" + newRepositoryName);
        Assert.assertTrue(enterRepoNameForDeleteStep.isSuccess());

        ConfirmationPage confirmationPage = createdNewRepositoryPage.clickConfirmationButtonToOnDeleteAttemptDialog();
        Assert.assertNotNull(confirmationPage);

    }
}
