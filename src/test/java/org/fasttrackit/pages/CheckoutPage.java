package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CheckoutPage extends PageObject {

    @FindBy(id = "billing_first_name")
    private WebElementFacade firstNameTextField;

    @FindBy(id = "billing_last_name")
    private WebElementFacade lastNameTextField;

    @FindBy(id = "billing_country")
    private WebElementFacade countryList;

    @FindBy(id = "billing_address_1")
    private WebElementFacade streetAddressTextField;

    @FindBy(id = "billing_city")
    private WebElementFacade townOrCityTextField;

    @FindBy(id = "billing_state")
    private WebElementFacade countyList;

    @FindBy(id = "billing_postcode")
    private WebElementFacade postcodeTextField;

    @FindBy(id = "billing_phone")
    private WebElementFacade phoneTextField;

    @FindBy(id = "billing_email")
    private WebElementFacade emailAddressTextField;

    @FindBy(id = "place_order")
    private WebElementFacade placeOrderButton;

    @FindBy(css = ".woocommerce-error")
    private WebElementFacade errorText;

    @FindBy(css = ".woocommerce .woocommerce-info:nth-child(1)")
    private WebElementFacade returningCustomerText;

    @FindBy(css = ".showlogin")
    private WebElementFacade clickHereToLoginButton;

    @FindBy(id = "username")
    private WebElementFacade usernameOrEmailTextField;

    @FindBy(id = "password")
    private WebElementFacade passwordTextField;

    @FindBy(css = "[name='login']")
    private WebElementFacade loginButton;


    public void setFirstNameTextField(String value) {
        typeInto(firstNameTextField, value);
    }

    public void setLastNameTextField(String value) {
        typeInto(lastNameTextField, value);
    }

    public void setStreetAddressTextField(String value) {
        typeInto(streetAddressTextField, value);
    }

    public void setPostcodeOrZIPTextField(String value) {
        typeInto(postcodeTextField, value);
    }

    public void setPhoneTextField(String value) {
        typeInto(phoneTextField, value);
    }

    public void setEmailAddressTextField(String value) {
        typeInto(emailAddressTextField, value);
    }

    public void clickOnThePlaceOrderButton() {
        clickOn(placeOrderButton);
    }

    public void selectCounty(String value) {
        countyList.selectByVisibleText(value);
    }

    public void selectCountry(String value) {
        countryList.selectByVisibleText(value);
    }

    public void setTownOrCityTextField(String value) {
        typeInto(townOrCityTextField, value);
    }

    public String getErrorText() {
        return errorText.getText();
    }

    public String getReturningCustomerText() {
        return returningCustomerText.getText();
    }

    public void clickOnTheClickHereToLoginButton() {
        clickOn(clickHereToLoginButton);
    }

    public void setUsernameOrEmailTextField(String value) {
        typeInto(usernameOrEmailTextField, value);
    }

    public void setPasswordTextField(String value) {
        typeInto(passwordTextField, value);
    }

    public void clickOnTheLoginButton() {
        clickOn(loginButton);
    }
}
