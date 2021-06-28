package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.RegisterSteps;
import org.fasttrackit.utils.BaseTest;
import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class RegisterTest extends BaseTest {

    @Steps
    private RegisterSteps registerSteps;


    @Test
    public void registerWithValidCredentials() {
        registerSteps.navigateToMyAccountPage();
        registerSteps.enterValidCredentials(Constants.GENERATE_EMAIL, Constants.GENERATE_9_CHARACTERS_PASSWORD);
        registerSteps.clickOnTheRegisterButton();
        registerSteps.checkUserIsRegistered();
    }

    @Test
    public void registerWithEmptyEmailField() {
        registerSteps.navigateToMyAccountPage();
        registerSteps.clickOnTheRegisterButton();
        registerSteps.checkEmptyEmailFieldErrorText("Error: Please provide a valid email address.");
    }

    @Test
    public void registerWithEmptyPasswordField() {
        registerSteps.navigateToMyAccountPage();
        registerSteps.enterEmail(Constants.GENERATE_EMAIL);
        registerSteps.clickOnTheRegisterButton();
        registerSteps.checkEmptyPasswordFieldErrorText("Error: Please enter an account password.");
    }

    @Test
    public void registerWithAVeryWeakPassword() {
        registerSteps.navigateToMyAccountPage();
        registerSteps.enterValidCredentials(Constants.GENERATE_EMAIL, Constants.GENERATE_2_CHARACTERS_PASSWORD);
        registerSteps.checkVeryWeakPasswordText("Very weak - Please enter a stronger password.");
    }

    @Test
    public void registerWithAWeakPassword() {
        registerSteps.navigateToMyAccountPage();
        registerSteps.enterValidCredentials(Constants.GENERATE_EMAIL, Constants.GENERATE_4_CHARACTERS_PASSWORD);
        registerSteps.checkWeakPasswordText("Weak - Please enter a stronger password.");
    }

    @Test
    public void registerWithAnEmailOverTheCharacterLimit() {
        registerSteps.navigateToMyAccountPage();
        registerSteps.enterCredentials(Constants.GENERATE_EMAIL_WITH_OVER_LIMIT_CHARACTERS, Constants.GENERATE_9_CHARACTERS_PASSWORD);
        registerSteps.clickOnTheRegisterButton();
        registerSteps.checkErrorTextForMoreThanCharactersThanTheLimit("Error: Error: Couldn’t register you… please contact us if you continue to have problems.");
    }

    @Test
    public void registerWithExistingAccount() {
        registerSteps.navigateToMyAccountPage();
        registerSteps.enterValidCredentials(Constants.USER_EMAIL, Constants.USER_PASSWORD);
        registerSteps.clickOnTheRegisterButton();
        registerSteps.checkExistingAccountText("Error: An account is already registered with your email address. Please log in.");
    }
}
