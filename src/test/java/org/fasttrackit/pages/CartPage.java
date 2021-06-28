package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class CartPage extends PageObject {

    @FindBy(css = ".cart tbody .product-name a")
    private List<WebElementFacade> productList;

    @FindBy(css = ".wc-proceed-to-checkout a")
    private WebElementFacade proceedToCheckoutButton;


    public boolean isProductAddedSuccessful(String value) {
        for (WebElementFacade element : productList) {
            if (element.getText().equals(value)) {
                System.out.println("actual:" + element.getText() + "expected" + value);
                return true;
            }
        }
        return false;
    }

    public void clickOnTheProceedToCheckoutButton() {
        clickOn(proceedToCheckoutButton);
    }
}
