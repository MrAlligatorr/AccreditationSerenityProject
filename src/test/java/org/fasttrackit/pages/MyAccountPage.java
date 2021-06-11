package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Test;

public class MyAccountPage extends PageObject {

    @FindBy(id = "reg_email")
    private WebElementFacade registerEmailTextField;

    @FindBy(id = "reg_password")
    private WebElementFacade registerPasswordTextField;

    @FindBy(css = "[name='register']")
    private WebElementFacade registerButton;

    @FindBy(css = ".woocommerce-error li")
    private WebElementFacade errorText;

    @FindBy(css = ".short")
    private WebElementFacade veryWeakPasswordText;

    @FindBy(css = ".bad")
    private WebElementFacade weakPasswordText;

    @FindBy(id = "username")
    private WebElementFacade loginUsernameTextField;

    @FindBy(id = "password")
    private WebElementFacade loginPasswordTextField;

    @FindBy(css = "[name='login']")
    private WebElementFacade loginButton;

    @FindBy(css = "P:nth-child(1)")
    private WebElementFacade loginSuccessfulText;

    @FindBy(id = "rememberme")
    private WebElementFacade rememberMeButton;

    @FindBy(css = ".lost_password a")
    private WebElementFacade lostYourPasswordButton;

    @FindBy(css = ".woocommerce-MyAccount-content p:nth-child(1)")
    private WebElementFacade confirm;


    String randomEmail = "";

    public void setRegisterEmailTextField(String value) {
        randomEmail = value;
        typeInto(registerEmailTextField, randomEmail);
    }

    public boolean userIsRegisteredSuccessfulText() {
        if (confirm.getText().equals("Hello " + randomEmail.replaceAll("@gmail.com", "") +
                " (not " + randomEmail.replaceAll("@gmail.com", "") + "? Log out)")) {
            return true;
        }
        return false;
    }

    public void setRegisterPasswordTextField(String value) {
        typeInto(registerPasswordTextField, value);
    }

    public void clickOnTheRegisterButton() {
        clickOn(registerButton);
    }

    public String checkErrorText() {
        return errorText.getText();
    }

    public String checkVeryWeakPasswordText() {
        return veryWeakPasswordText.getText();
    }

    public String checkWeakPasswordText() {
        return weakPasswordText.getText();
    }

    public void setLoginUsernameTextField(String value) {
        typeInto(loginUsernameTextField, value);
    }

    public void setLoginPasswordTextField(String value) {
        typeInto(loginPasswordTextField, value);
    }

    public void clickOnTheLoginButton() {
        clickOn(loginButton);
    }

    public String checkLoginSuccessfulText() {
        return loginSuccessfulText.getText();
    }

    public void clickOnTheRememberMeButton() {
        clickOn(rememberMeButton);
    }

    public void clickOnTheLostYourPasswordButton() {
        clickOn(lostYourPasswordButton);
    }
}
