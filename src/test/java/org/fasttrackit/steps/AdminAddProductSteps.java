package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.AdminAddProductPage;
import org.fasttrackit.pages.AdminHomepage;
import org.fasttrackit.pages.AdminLoginPage;
import org.fasttrackit.pages.HomePage;
import org.junit.Assert;

public class AdminAddProductSteps {

    private AdminHomepage adminHomepage;
    private AdminAddProductPage adminAddProductPage;
    private HomePage homePage;
    private AdminLoginPage adminLoginPage;


    @Step
    public void navigateToAddProductPage() {
        adminHomepage.hoverOverProduct();
        adminHomepage.clickOnTheAddProductButton();
    }

    @Step
    public void setProductName(String value) {
        adminAddProductPage.setProductNameTextField(value);
    }

    @Step
    public void setProductRegularPrice(String value) {
        adminAddProductPage.setRegularPriceTextField(value);
    }

    @Step
    public void addItem() {
        adminAddProductPage.clickOnThePublishButton();
        adminAddProductPage.waitForThePublishedSuccessfulText();
    }

    @Step
    public void checkProductPublishedText(String value) {
        Assert.assertEquals(value, adminAddProductPage.getProductPublishedText());
    }

    @Step
    public void doAddProductInAdminAndLogOut(String productName, String productPrice) {
        homePage.open();
        homePage.clickOnTheAdminLoginButton();
        adminLoginPage.setUsernameTextField("admin");
        adminLoginPage.setPasswordTextField("parola11");
        adminLoginPage.clickOnTheLoginButton();
        adminHomepage.hoverOverProduct();
        adminHomepage.clickOnTheAddProductButton();
        adminAddProductPage.setProductNameTextField(productName);
        adminAddProductPage.setRegularPriceTextField(productPrice);
        adminAddProductPage.clickOnThePublishButton();
        adminAddProductPage.waitForThePublishedSuccessfulText();
        adminHomepage.hoverOnTheProfileAdminButton();
        adminHomepage.clickOnTheLogOutButton();
        adminLoginPage.clickOnTheBackToSiteButton();
    }

    @Step
    public void doAdd3ProductsInAdminAndLogOut(String firstProductName, String firstProductPrice, String secondProductName,
                                               String secondProductPrice, String thirdProductName, String thirdProductPrice) {
        homePage.open();
        homePage.clickOnTheAdminLoginButton();
        adminLoginPage.setUsernameTextField("admin");
        adminLoginPage.setPasswordTextField("parola11");
        adminLoginPage.clickOnTheLoginButton();
        adminHomepage.hoverOverProduct();
        adminHomepage.clickOnTheAddProductButton();
        adminAddProductPage.setProductNameTextField(firstProductName);
        adminAddProductPage.setRegularPriceTextField(firstProductPrice);
        adminAddProductPage.clickOnThePublishButton();
        adminAddProductPage.waitForThePublishedSuccessfulText();
        adminAddProductPage.clickOnAddNewButton();
        adminAddProductPage.setSecondProductNameTextField(secondProductName);
        adminAddProductPage.setSecondRegularPriceTextField(secondProductPrice);
        adminAddProductPage.clickOnThePublishButton();
        adminAddProductPage.waitForThePublishedSuccessfulText();
        adminAddProductPage.clickOnAddNewButton();
        adminAddProductPage.setThirdProductNameTextField(thirdProductName);
        adminAddProductPage.setThirdRegularPriceTextField(thirdProductPrice);
        adminAddProductPage.clickOnThePublishButton();
        adminAddProductPage.waitForThePublishedSuccessfulText();
        adminHomepage.hoverOnTheProfileAdminButton();
        adminHomepage.clickOnTheLogOutButton();
        adminLoginPage.clickOnTheBackToSiteButton();
    }

    @Step
    public void clickOnAddNewButton() {
        adminAddProductPage.clickOnAddNewButton();
    }
}
