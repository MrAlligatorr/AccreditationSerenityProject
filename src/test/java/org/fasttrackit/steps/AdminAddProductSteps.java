package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.AdminAddProductPage;
import org.fasttrackit.pages.AdminHomepage;
import org.junit.Assert;

public class AdminAddProductSteps {

    private AdminHomepage adminHomepage;
    private AdminAddProductPage adminAddProductPage;


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
    }

    @Step
    public void checkProductPublishedText(String value) {
        Assert.assertEquals(value, adminAddProductPage.getProductPublishedText());
    }

    @Step
    public void doAddProductFromAdmin(String productName, String productPrice) {
        adminHomepage.hoverOverProduct();
        adminHomepage.clickOnTheAddProductButton();
        adminAddProductPage.setProductNameTextField(productName);
        adminAddProductPage.setRegularPriceTextField(productPrice);
        adminAddProductPage.clickOnThePublishButton();
    }
}
