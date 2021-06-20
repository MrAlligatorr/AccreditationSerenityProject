package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.CartPage;
import org.fasttrackit.pages.CheckoutPage;
import org.fasttrackit.pages.OrderReceivedPage;
import org.junit.Assert;

public class CheckoutSteps {

    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private OrderReceivedPage orderReceivedPage;


    @Step
    public void clickOnProceedToCheckout() {
        cartPage.clickOnTheProceedToCheckoutButton();
    }

    @Step
    public void enterValidCredentials(String firstName, String lastName, String country, String streetAddress, String townOrCity,
                                      String county, String postcodeOrZIP, String phoneNumber, String emailAddress) {
        checkoutPage.setFirstNameTextField(firstName);
        checkoutPage.setLastNameTextField(lastName);
        checkoutPage.selectCountry(country);
        checkoutPage.setStreetAddressTextField(streetAddress);
        checkoutPage.setTownOrCityTextField(townOrCity);
        checkoutPage.selectCounty(county);
        checkoutPage.setPostcodeOrZIPTextField(postcodeOrZIP);
        checkoutPage.setPhoneTextField(phoneNumber);
        checkoutPage.setEmailAddressTextField(emailAddress);
    }

    @Step
    public void clickOnThePlaceOrderButton() {
        checkoutPage.clickOnThePlaceOrderButton();
    }

    @Step
    public void checkOrderReceivedText(String value) {
        Assert.assertEquals(value, orderReceivedPage.getOrderReceivedText());
    }

    @Step
    public void checkThankYouText(String value) {
        Assert.assertEquals(value, orderReceivedPage.getThankYouText());
    }

    @Step
    public void checkErrorText(String value) {
        Assert.assertEquals(value, checkoutPage.getErrorText());
    }

    @Step
    public void enterPhoneAndEmailAddress(String phoneNumber, String emailAddress) {
        checkoutPage.setFirstNameTextField("Betty");
        checkoutPage.setLastNameTextField("Bug");
        checkoutPage.selectCountry("Romania");
        checkoutPage.setStreetAddressTextField("Hey 20");
        checkoutPage.setTownOrCityTextField("HappyTown");
        checkoutPage.selectCounty("Cluj");
        checkoutPage.setPostcodeOrZIPTextField("234525");
        checkoutPage.setPhoneTextField(phoneNumber);
        checkoutPage.setEmailAddressTextField(emailAddress);
    }

    @Step
    public void checkUserIsNotLoggedIn(String expected) {
        Assert.assertEquals(expected, checkoutPage.getReturningCustomerText());
    }

    @Step
    public void clickOnTheClickHereToLoginButton() {
        checkoutPage.clickOnTheClickHereToLoginButton();
    }

    @Step
    public void enterCheckoutLoginCredentials(String usernameOrEmail, String password) {
        checkoutPage.setUsernameOrEmailTextField(usernameOrEmail);
        checkoutPage.setPasswordTextField(password);
    }

    @Step
    public void clickOnTheCheckoutLoginButton() {
        checkoutPage.clickOnTheLoginButton();
    }

    @Step
    public void checkIfEmailAddressIsCorrect(String expected) {
        Assert.assertEquals(expected.toLowerCase(), orderReceivedPage.getEmail());
    }

    @Step
    public void checkBillingAddressInformationIsCorrect(String expected) {
        Assert.assertEquals(expected, orderReceivedPage.getBillingInformation());
    }
}