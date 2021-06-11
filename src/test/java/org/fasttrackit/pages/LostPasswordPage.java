package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LostPasswordPage extends PageObject {

    @FindBy(id = "user_login")
    private WebElementFacade usernameTextField;

    @FindBy(css = ".button")
    private WebElementFacade resetPasswordButton;

    @FindBy(css = ".woocommerce-message")
    private WebElementFacade confirmationText;


    public void setUsernameTextField(String value) {
        typeInto(usernameTextField, value);
    }

    public void clickOnResetPasswordButton() {
        clickOn(resetPasswordButton);
    }

    public String getConfirmationText() {
        return confirmationText.getText();
    }
}
