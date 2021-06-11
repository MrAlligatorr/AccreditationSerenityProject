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


    public void clickOnTheAddToCartButton(){
        clickOn(addToCartButton);
    }

    public String getAddedToCartSuccessfulText(){
        return addedToCartSuccessfulText.getText();
    }

    public void clickOnTheViewCartButton(){
        clickOn(viewCartButton);
    }
}
