package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;

@DefaultUrl("http://qa1.fasttrackit.org:8008/")
public class HomePage extends PageObject {

    @FindBy(css = "#menu-item-58 a")
    private WebElementFacade myAccountButton;

    @FindBy(css = "aside#meta-2 > ul > li:nth-of-type(2) > a")
    private WebElementFacade adminLoginButton;

    @FindBy(css = ".search-field")
    private WebElementFacade searchBarTextField;

    public void clickOnTheMyAccountButton() {
        clickOn(myAccountButton);
    }

    public void clickOnTheAdminLoginButton() {
        clickOn(adminLoginButton);
    }

    public void setSearchBarTextField(String value){
        typeInto(searchBarTextField,value+"\n");
    }
}
