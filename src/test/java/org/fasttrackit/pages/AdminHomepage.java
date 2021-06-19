package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AdminHomepage extends PageObject {

    @FindBy(css = ".welcome-panel-content h2")
    private WebElementFacade welcomeText;

    @FindBy(css = "#menu-posts-product .wp-menu-name")
    private WebElementFacade productCategoryButton;

    @FindBy(css = "li#menu-posts-product > ul > li:nth-of-type(3) > a")
    private WebElementFacade addNewProductButton;

    @FindBy(css = "li#wp-admin-bar-my-account > .ab-item")
    private WebElementFacade profileAdminButton;

    @FindBy(css = "li#wp-admin-bar-logout > .ab-item")
    private WebElementFacade logOutButton;

    @FindBy(css = ".menu-icon-comments div:nth-child(3)")
    private WebElementFacade commentsButton;


    public String getWelcomeText() {
        return welcomeText.getText();
    }

    public void hoverOverProduct() {
        withAction().moveToElement(productCategoryButton).perform();
    }

    public void clickOnTheAddProductButton() {
        addNewProductButton.waitUntilVisible().click();
    }

    public void hoverOnTheProfileAdminButton() {
        withAction().moveToElement(profileAdminButton).perform();
    }

    public void clickOnTheLogOutButton() {
        logOutButton.waitUntilVisible().click();
    }
}
