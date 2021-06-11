package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.MyAccountPage;
import org.junit.Assert;

public class RegisterSteps {

    private HomePage homePage;
    private MyAccountPage myAccountPage;


    @Step
    public void checkUserIsRegistered() {
        Assert.assertTrue(myAccountPage.userIsRegisteredSuccessfulText());
    }

    @Step
    public void navigateToMyAccountPage() {
        homePage.open();
        homePage.clickOnTheMyAccountButton();
    }

    @Step
    public void enterValidCredentials(String email, String password) {
        myAccountPage.setRegisterEmailTextField(email);
        myAccountPage.setRegisterPasswordTextField(password);
    }

    @Step
    public void clickOnTheRegisterButton() {
        myAccountPage.clickOnTheRegisterButton();
    }


    @Step
    public void checkEmptyEmailFieldErrorText(String expectedText) {
        Assert.assertEquals(expectedText, myAccountPage.checkErrorText());
    }

    @Step
    public void enterEmail(String email) {
        myAccountPage.setRegisterEmailTextField(email);
    }

    @Step
    public void checkEmptyPasswordFieldErrorText(String expectedText) {
        Assert.assertEquals(expectedText, myAccountPage.checkErrorText());
    }

    @Step
    public void checkVeryWeakPasswordText(String expectedText) {
        Assert.assertEquals(expectedText, myAccountPage.checkVeryWeakPasswordText());
    }

    @Step
    public void checkWeakPasswordText(String expectedText) {
        Assert.assertEquals(expectedText, myAccountPage.checkWeakPasswordText());
    }
}
