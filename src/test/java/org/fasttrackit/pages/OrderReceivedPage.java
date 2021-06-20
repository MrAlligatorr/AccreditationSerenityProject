package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class OrderReceivedPage extends PageObject {

    @FindBy(css = ".entry-title")
    private WebElementFacade orderReceivedText;

    @FindBy(css = ".woocommerce-thankyou-order-received")
    private WebElementFacade thankYouText;

    @FindBy(css = ".email > strong")
    private WebElementFacade emailText;

    @FindBy(css = ".woocommerce-customer-details address")
    private WebElementFacade billingAddressInformation;


    public String getOrderReceivedText() {
        waitForAngularRequestsToFinish();
        waitABit(4000);
        return orderReceivedText.getText();
    }

    public String getThankYouText() {
        return thankYouText.getText();
    }

    public String getEmail() {
        waitForAngularRequestsToFinish();
        waitABit(3000);
        return emailText.getText();
    }

    public String getBillingInformation() {
        return billingAddressInformation.getText();
    }
}
