package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductPage extends PageObject {

    @FindBy(css = ".single_add_to_cart_button")
    private WebElementFacade addToCartButton;

    @FindBy(css = ".woocommerce-message")
    private WebElementFacade addedToCartSuccessfulText;

    @FindBy(css = ".wc-forward")
    private WebElementFacade viewCartButton;

    @FindBy(css = ".search-field")
    private WebElementFacade searchField;


    public void clickOnTheAddToCartButton() {
        clickOn(addToCartButton);
    }

    public String getAddedToCartSuccessfulText() {
        waitForAngularRequestsToFinish();
        return addedToCartSuccessfulText.getText().replaceAll("View cart" + "\n", "");
    }

    public void clickOnTheViewCartButton() {
        clickOn(viewCartButton);
    }

    public void setSearchField(String value){
        typeInto(searchField,value+"\n");
    }
}
