package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class CartPage extends PageObject {

    @FindBy(css = ".cart tbody")
    private List<WebElementFacade> productList;

    @FindBy(css = ".wc-proceed-to-checkout a")
    private WebElementFacade proceedToCheckoutButton;

    @FindBy(css = ".product-name a")
    private WebElementFacade productNames;


    public boolean isProductAddedSuccessful(String value) {
        for (WebElementFacade element : productList) {
            if (element.findElement(By.cssSelector(".product-name a")).getText().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean areProductsAddedSuccessful(String value) {
        for (WebElementFacade element : productList) {
            for (int i = 0; i <= 0; i++) {
                if (element.findElement(By.cssSelector(".product-name a:nth-child(" + i + ")")).getText().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSecondProductAddedSuccessful(String value) {
        for (WebElementFacade element : productList) {
            if (element.findElement(By.cssSelector(".product-name a")).getText().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean isThirdProductAddedSuccessful(String value) {
        for (WebElementFacade element : productList) {
            if (element.findElement(By.cssSelector(".product-name a")).getText().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public void clickOnTheProceedToCheckoutButton() {
        clickOn(proceedToCheckoutButton);
    }
}
