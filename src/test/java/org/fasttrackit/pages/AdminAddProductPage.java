package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AdminAddProductPage extends PageObject {

    @FindBy(id = "title")
    private WebElementFacade productNameTextField;

    @FindBy(id = "_regular_price")
    private WebElementFacade regularPriceTextField;

    @FindBy(id = "publish")
    private WebElementFacade publishButton;

    @FindBy(css = "[aria-label] #message:nth-child(4) p")
    private WebElementFacade productPublishedText;

    String productNameMemo = "";
    String productPriceMemo = "";

    public void setProductNameTextField(String value) {
        productNameMemo = value;
        typeInto(productNameTextField, value);
    }

    public void setRegularPriceTextField(String value) {
        productPriceMemo = value;
        typeInto(waitFor(regularPriceTextField), value);
    }

    public void clickOnThePublishButton() {
        clickOn(publishButton);
    }

    public String getProductPublishedText() {
        return productPublishedText.getText();
    }

    public String getProductNameMemo() {
        return productNameMemo;
    }

    public String getProductPriceMemo() {
        return productPriceMemo;
    }
}
