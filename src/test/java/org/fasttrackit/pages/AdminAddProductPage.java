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

    @FindBy(css = ".page-title-action")
    private WebElementFacade addNewButton;


    private static String productNameMemo = "";
    private static String productPriceMemo = "";
    private static String secondProductNameMemo = "";
    private static String secondProductPriceMemo = "";
    private static String thirdProductNameMemo = "";
    private static String thirdProductPriceMemo = "";


    public void setProductNameTextField(String value) {
        productNameMemo = value;
        typeInto(productNameTextField, value);
    }

    public void setRegularPriceTextField(String value) {
        productPriceMemo = value;
        typeInto(waitFor(regularPriceTextField), value);
    }

    public void setSecondProductNameTextField(String value) {
        secondProductNameMemo = value;
        typeInto(productNameTextField, value);
    }

    public void setSecondRegularPriceTextField(String value) {
        secondProductPriceMemo = value;
        typeInto(waitFor(regularPriceTextField), value);
    }

    public void setThirdProductNameTextField(String value) {
        thirdProductNameMemo = value;
        typeInto(productNameTextField, value);
    }

    public void setThirdRegularPriceTextField(String value) {
        thirdProductPriceMemo = value;
        typeInto(waitFor(regularPriceTextField), value);
    }

    public void clickOnThePublishButton() {
        waitForAngularRequestsToFinish();
        waitABit(2000);
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

    public String getSecondProductNameMemo() {
        return secondProductNameMemo;
    }

    public String getSecondProductPriceMemo() {
        return secondProductPriceMemo;
    }

    public String getThirdProductNameMemo() {
        return thirdProductNameMemo;
    }

    public String getThirdProductPriceMemo() {
        return thirdProductPriceMemo;
    }

    public void waitForThePublishedSuccessfulText() {
        waitFor(productPublishedText);
    }

    public void clickOnAddNewButton() {
        clickOn(addNewButton);
    }
}
