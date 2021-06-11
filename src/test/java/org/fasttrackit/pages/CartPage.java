package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class CartPage extends PageObject {

    @FindBy(css = ".cart tbody")
    private List<WebElementFacade> productList;


    public boolean isProductWasAddedSuccessful(String value) {
        for (WebElementFacade element : productList) {
            if (element.findElement(By.cssSelector(".product-name a")).getText().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
