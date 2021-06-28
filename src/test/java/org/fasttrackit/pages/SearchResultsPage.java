package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class SearchResultsPage extends PageObject {

    @FindBy(id = "main")
    private List<WebElementFacade> productNameList;

    @FindBy(css = ".entry-title a")
    private WebElementFacade productNameButton;


    public boolean checkItemIsFound(String value) {
        for (WebElementFacade element : productNameList) {
            if (productNameButton.getText().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean clickOnTheItem(String value) {
        for (WebElementFacade element : productNameList) {
            if (productNameButton.getText().equalsIgnoreCase(value)) {
                productNameButton.click();
                return true;
            }
        }
        return false;
    }
}
