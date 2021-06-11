package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.LostPasswordPage;
import org.fasttrackit.pages.MyAccountPage;
import org.fasttrackit.utils.ExternalSite;
import org.junit.Assert;

public class LoginSteps {

    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private ExternalSite externalSite;
    private LostPasswordPage lostPasswordPage;

    @Step
    public void navigateToMyAccount() {
        homePage.open();
        homePage.clickOnTheMyAccountButton();
    }

    @Step
    public void enterCredentials(String username, String password) {
        myAccountPage.setLoginUsernameTextField(username);
        myAccountPage.setLoginPasswordTextField(password);
    }

    @Step
    public void clickOnTheLoginButton() {
        myAccountPage.clickOnTheLoginButton();
    }

    @Step
    public void checkUserIsLoggedIn(String value) {
        Assert.assertEquals(value, myAccountPage.checkLoginSuccessfulText());
    }

    @Step
    public void checkEmptyUsernameErrorText(String value) {
        Assert.assertEquals(value, myAccountPage.checkErrorText());
    }

    @Step
    public void checkEmptyPasswordErrorText(String value) {
        Assert.assertEquals(value, myAccountPage.checkErrorText());
    }

    @Step
    public void enterUsername(String value) {
        myAccountPage.setLoginUsernameTextField(value);
    }

    @Step
    public void checkInvalidEmailAddressErrorText(String value) {
        Assert.assertEquals(value, myAccountPage.checkErrorText());
    }

    @Step
    public void checkInvalidPasswordErrorText(String value) {
        Assert.assertEquals(value, myAccountPage.checkErrorText());
    }

    @Step
    public void clickOnTheRememberMeButton() {
        myAccountPage.clickOnTheRememberMeButton();
    }

    @Step
    public void leaveTheSite() {
        externalSite.open();
    }

    @Step
    public void clickOnTheLostYourPasswordButton() {
        myAccountPage.clickOnTheLostYourPasswordButton();
    }

    @Step
    public void setUsernameFieldOnTheLostYourPasswordPage(String value) {
        lostPasswordPage.setUsernameTextField(value);
    }

    @Step
    public void clickOnTheResetPasswordButton() {
        lostPasswordPage.clickOnResetPasswordButton();
    }

    @Step
    public void checkTheResetConfirmationText(String value) {
        Assert.assertEquals(value, lostPasswordPage.getConfirmationText());
    }
}
