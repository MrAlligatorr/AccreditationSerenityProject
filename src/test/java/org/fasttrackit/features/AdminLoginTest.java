package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.AdminLoginSteps;
import org.fasttrackit.utils.BaseTest;
import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class AdminLoginTest extends BaseTest {

    @Steps
    private AdminLoginSteps adminLoginSteps;


    @Test
    public void adminLoginWithValidCredentials() {
        adminLoginSteps.navigateToAdminLogin();
        adminLoginSteps.setCredentials("admin", "parola11");
        adminLoginSteps.clickOnTheLoginButton();
        adminLoginSteps.checkAdminWelcomeText("Welcome to WordPress!");
    }

    @Test
    public void adminLoginWithEmptyUsername() {
        adminLoginSteps.navigateToAdminLogin();
        adminLoginSteps.setPassword(Constants.GENERATE_4_CHARACTERS_PASSWORD);
        adminLoginSteps.clickOnTheLoginButton();
        adminLoginSteps.checkErrorTextIsCorrect("ERROR: The username field is empty.");
    }

    @Test
    public void adminLoginWithEmptyPassword() {
        adminLoginSteps.navigateToAdminLogin();
        adminLoginSteps.setEmail(Constants.GENERATE_USERNAME);
        adminLoginSteps.clickOnTheLoginButton();
        adminLoginSteps.checkErrorTextIsCorrect("ERROR: The password field is empty.");
    }

    @Test
    public void adminLoginWithInvalidUsername() {
        adminLoginSteps.navigateToAdminLogin();
        adminLoginSteps.setCredentials(Constants.GENERATE_USERNAME, Constants.GENERATE_9_CHARACTERS_PASSWORD);
        adminLoginSteps.clickOnTheLoginButton();
        adminLoginSteps.checkErrorTextIsCorrect("ERROR: Invalid username. Lost your password?");
    }

    @Test
    public void adminLoginWithInvalidPassword() {
        adminLoginSteps.navigateToAdminLogin();
        adminLoginSteps.setCredentials("admin", Constants.GENERATE_9_CHARACTERS_PASSWORD);
        adminLoginSteps.clickOnTheLoginButton();
        adminLoginSteps.checkErrorTextIsCorrect("ERROR: The password you entered for the username admin is incorrect. Lost your password?");
    }

    @Test
    public void adminLoginWithInvalidEmail() {
        adminLoginSteps.navigateToAdminLogin();
        adminLoginSteps.setCredentials(Constants.GENERATE_EMAIL, Constants.GENERATE_9_CHARACTERS_PASSWORD);
        adminLoginSteps.clickOnTheLoginButton();
        adminLoginSteps.checkErrorTextIsCorrect("ERROR: Invalid email address. Lost your password?");
    }
}
