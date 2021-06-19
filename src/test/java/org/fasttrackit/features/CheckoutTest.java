package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.AddToCartSteps;
import org.fasttrackit.steps.AdminAddProductSteps;
import org.fasttrackit.steps.CheckoutSteps;
import org.fasttrackit.steps.SearchSteps;
import org.fasttrackit.utils.BaseTest;
import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class CheckoutTest extends BaseTest {

    @Steps
    private AdminAddProductSteps adminAddProductSteps;

    @Steps
    private SearchSteps searchSteps;

    @Steps
    private AddToCartSteps productDetailsSteps;

    @Steps
    private CheckoutSteps checkoutSteps;


    @Test
    public void checkoutWithValidCredentialsWithBeingLoggedIn() {
        adminAddProductSteps.doAddProductInAdminAndLogOut(Constants.GENERATE_PRODUCT_NAME, Constants.GENERATE_PRICE);
        searchSteps.doSearchAnItemAndClickOnIt();
        productDetailsSteps.clickOnAddToCart();
        productDetailsSteps.clickOnViewCart();
        checkoutSteps.clickOnProceedToCheckout();
        checkoutSteps.checkUserIsNotLoggedIn("Returning customer? Click here to login");
        checkoutSteps.enterValidCredentials("Betty", "Bug", "Romania", "Hey 20",
                "HappyTown", "Cluj", "234525", "0752597387", "Betty@gmail.com");
        checkoutSteps.clickOnThePlaceOrderButton();
        checkoutSteps.checkOrderReceivedText("Order received");
        checkoutSteps.checkThankYouText("Thank you. Your order has been received.");
    }

    @Test
    public void checkoutWithEmptyCredentials() {
        adminAddProductSteps.doAddProductInAdminAndLogOut(Constants.GENERATE_PRODUCT_NAME, Constants.GENERATE_PRICE);
        searchSteps.doSearchAnItemAndClickOnIt();
        productDetailsSteps.clickOnAddToCart();
        productDetailsSteps.clickOnViewCart();
        checkoutSteps.clickOnProceedToCheckout();
        checkoutSteps.clickOnThePlaceOrderButton();
        checkoutSteps.checkErrorText("Billing First name is a required field.\n" +
                "Billing Last name is a required field.\n" +
                "Billing Street address is a required field.\n" +
                "Billing Town / City is a required field.\n" +
                "Billing Postcode / ZIP is a required field.\n" +
                "Billing Phone is a required field.\n" +
                "Billing Email address is a required field.");
    }

    @Test
    public void checkoutWithInvalidPhoneAndEmailAddressFormat() {
        adminAddProductSteps.doAddProductInAdminAndLogOut(Constants.GENERATE_PRODUCT_NAME, Constants.GENERATE_PRICE);
        searchSteps.doSearchAnItemAndClickOnIt();
        productDetailsSteps.clickOnAddToCart();
        productDetailsSteps.clickOnViewCart();
        checkoutSteps.clickOnProceedToCheckout();
        checkoutSteps.enterPhoneAndEmailAddress("invalid", "123");
        checkoutSteps.clickOnThePlaceOrderButton();
        checkoutSteps.checkErrorText("Billing Phone is not a valid phone number.\n" +
                "Billing Email address is not a valid email address.");
    }

    @Test
    public void returningCustomer() {
        adminAddProductSteps.doAddProductInAdminAndLogOut(Constants.GENERATE_PRODUCT_NAME, Constants.GENERATE_PRICE);
        searchSteps.doSearchAnItemAndClickOnIt();
        productDetailsSteps.clickOnAddToCart();
        productDetailsSteps.clickOnViewCart();
        checkoutSteps.clickOnProceedToCheckout();
        checkoutSteps.clickOnTheClickHereToLoginButton();
        checkoutSteps.enterCheckoutLoginCredentials(Constants.USER_EMAIL, Constants.USER_PASSWORD);
        checkoutSteps.clickOnTheCheckoutLoginButton();
        checkoutSteps.clickOnThePlaceOrderButton();
        checkoutSteps.checkIfEmailAddressIsCorrect(Constants.USER_EMAIL);
        checkoutSteps.checkBillingAddressInformationIsCorrect("Andreica Razvan\nMemo 20\nCluj-Napoca\nCluj\n123456\n01111111111\n\nliviu@gmail.com");
    }
}
