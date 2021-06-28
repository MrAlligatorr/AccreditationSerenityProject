package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.AdminHomepage;
import org.fasttrackit.pages.AdminLoginPage;
import org.fasttrackit.pages.HomePage;
import org.junit.Assert;

public class AdminLoginSteps {

    private HomePage homePage;
    private AdminLoginPage adminLoginPage;
    private AdminHomepage adminHomepage;


    @Step
    public void navigateToAdminLogin() {
        homePage.open();
        homePage.clickOnTheAdminLoginButton();
    }

    @Step
    public void setCredentials(String username, String password) {
        adminLoginPage.setUsernameTextField(username);
        adminLoginPage.setPasswordTextField(password);
    }

    @Step
    public void clickOnTheLoginButton() {
        adminLoginPage.clickOnTheLoginButton();
    }

    @Step
    public void checkAdminWelcomeText(String value) {
        Assert.assertEquals(value, adminHomepage.getWelcomeText());
    }

    @Step
    public void doAdminLogin() {
        homePage.open();
        homePage.clickOnTheAdminLoginButton();
        adminLoginPage.setUsernameTextField("admin");
        adminLoginPage.setPasswordTextField("parola11");
        adminLoginPage.clickOnTheLoginButton();
    }

    @Step
    public void checkErrorTextIsCorrect(String value){
        Assert.assertEquals(value, adminLoginPage.getErrorText());
    }

    @Step
    public void setEmail(String value){
        adminLoginPage.setUsernameTextField(value);
    }

    @Step
    public void setPassword(String value){
        adminLoginPage.setPasswordTextField(value);
    }
}
