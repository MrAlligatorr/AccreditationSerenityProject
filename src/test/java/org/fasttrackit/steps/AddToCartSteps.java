package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.AdminAddProductPage;
import org.fasttrackit.pages.CartPage;
import org.fasttrackit.pages.ProductPage;
import org.junit.Assert;

public class AddToCartSteps {

    private ProductPage productPage;
    private CartPage cartPage;
    private AdminAddProductPage adminAddProductPage;


    @Step
    public void clickOnAddToCart() {
        productPage.clickOnTheAddToCartButton();
    }

    @Step
    public void checkForAddedSuccessfulText(String value1, String value2) {
        System.out.println(productPage.getAddedToCartSuccessfulText());
        System.out.println(value1 + adminAddProductPage.getProductNameMemo() + value2);
        Assert.assertEquals(value1 + adminAddProductPage.getProductNameMemo() + value2, productPage.getAddedToCartSuccessfulText());
    }

    @Step
    public void clickOnViewCart() {
        productPage.clickOnTheViewCartButton();
    }

    @Step
    public void checkItemIsInCart() {
        Assert.assertTrue(cartPage.isProductWasAddedSuccessful(adminAddProductPage.getProductNameMemo()));
    }
}
