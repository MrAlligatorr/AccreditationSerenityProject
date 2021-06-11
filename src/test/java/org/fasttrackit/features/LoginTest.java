package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.LoginSteps;
import org.fasttrackit.utils.BaseTest;
import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Steps
    private LoginSteps loginSteps;


    @Test
    public void logInWithValidCredentials() {
        loginSteps.navigateToMyAccount();
        loginSteps.enterCredentials(Constants.USER_EMAIL, Constants.USER_PASSWORD);
        loginSteps.clickOnTheLoginButton();
        loginSteps.checkUserIsLoggedIn("Hello Liviu (not Liviu? Log out)");
    }

    @Test
    public void loginWithEmptyEmailField() {
        loginSteps.navigateToMyAccount();
        loginSteps.clickOnTheLoginButton();
        loginSteps.checkEmptyUsernameErrorText("Error: Username is required.");
    }

    @Test
    public void loginWithEmptyPasswordField() {
        loginSteps.navigateToMyAccount();
        loginSteps.enterUsername(Constants.USER_EMAIL);
        loginSteps.clickOnTheLoginButton();
        loginSteps.checkEmptyPasswordErrorText("ERROR: The password field is empty.");
    }

    @Test
    public void loginWithNonexistentEmail() {
        loginSteps.navigateToMyAccount();
        loginSteps.enterCredentials(Constants.GENERATE_EMAIL, "ifasbfhlbfuy3b237");
        loginSteps.clickOnTheLoginButton();
        loginSteps.checkInvalidEmailAddressErrorText("ERROR: Invalid email address. Lost your password?");
    }

    @Test
    public void loginWithWrongPassword() {
        loginSteps.navigateToMyAccount();
        loginSteps.enterCredentials(Constants.USER_EMAIL, "ifasbfhlbfuy3b237");
        loginSteps.clickOnTheLoginButton();
        loginSteps.checkInvalidPasswordErrorText("ERROR: The password you entered for the email address Liviu@gmail.com is incorrect. Lost your password?");
    }

    @Test
    public void loginAndCheckTheRememberMeButton() {
        loginSteps.navigateToMyAccount();
        loginSteps.enterCredentials(Constants.USER_EMAIL, Constants.USER_PASSWORD);
        loginSteps.clickOnTheRememberMeButton();
        loginSteps.clickOnTheLoginButton();
        loginSteps.leaveTheSite();
        loginSteps.navigateToMyAccount();
        loginSteps.checkUserIsLoggedIn("Hello Liviu (not Liviu? Log out)");
    }

    @Test
    public void lostPassword() {
        loginSteps.navigateToMyAccount();
        loginSteps.clickOnTheLostYourPasswordButton();
        loginSteps.setUsernameFieldOnTheLostYourPasswordPage("razvan@gmail.com");
        loginSteps.clickOnTheResetPasswordButton();
        loginSteps.checkTheResetConfirmationText("Password reset email has been sent.");
    }
}
