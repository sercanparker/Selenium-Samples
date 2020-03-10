package interfaces.github;

import concrete.TestStep;
import pages.github.ConfirmationPage;

/**
 * @author sercansensulun on 10.03.2020.
 */
public interface ICreatedNewRepositoryPage {
    TestStep clickSettings();
    TestStep clickOptions();
    TestStep clickDeleteThisRepositoryButton();
    TestStep enterRepositoryNameOnDeleteAttemptDialog(String repositoryName);
    ConfirmationPage clickConfirmationButtonToOnDeleteAttemptDialog();

}
