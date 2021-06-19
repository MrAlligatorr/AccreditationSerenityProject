package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AdminLoginPage extends PageObject {

    @FindBy(id = "user_login")
    private WebElementFacade usernameTextField;

    @FindBy(id = "user_pass")
    private WebElementFacade passwordTextField;

    @FindBy(id = "wp-submit")
    private WebElementFacade loginButton;

    @FindBy(css = "div#login > .message")
    private WebElementFacade logOutText;

    @FindBy(css = "#backtoblog a")
    private WebElementFacade backToSiteButton;


    public void setUsernameTextField(String value) {
        typeInto(usernameTextField, value);
    }

    public void setPasswordTextField(String value) {
        typeInto(passwordTextField, value);
    }

    public void clickOnTheLoginButton() {
        clickOn(loginButton);
    }

    public String getLogOutText() {
        return logOutText.getText();
    }

    public void clickOnTheBackToSiteButton() {
        clickOn(backToSiteButton);
    }
}
