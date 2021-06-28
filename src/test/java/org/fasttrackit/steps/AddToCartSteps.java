package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.AdminAddProductPage;
import org.fasttrackit.pages.CartPage;
import org.fasttrackit.pages.ProductPage;
import org.fasttrackit.pages.SearchResultsPage;
import org.junit.Assert;

public class AddToCartSteps {

    private ProductPage productPage;
    private CartPage cartPage;
    private AdminAddProductPage adminAddProductPage;
    private SearchResultsPage searchResultsPage;


    @Step
    public void clickOnAddToCart() {
        productPage.clickOnTheAddToCartButton();
    }

    @Step
    public void checkForAddedSuccessfulText(String value1, String value2) {
        Assert.assertEquals(value1 + adminAddProductPage.getProductNameMemo() + value2, productPage.getAddedToCartSuccessfulText());
    }

    @Step
    public void checkForSecondAddedSuccessfulText(String value1, String value2) {
        Assert.assertEquals(value1 + adminAddProductPage.getSecondProductNameMemo() + value2, productPage.getAddedToCartSuccessfulText());
    }

    @Step
    public void checkForThirdAddedSuccessfulText(String value1, String value2) {
        Assert.assertEquals(value1 + adminAddProductPage.getThirdProductNameMemo() + value2, productPage.getAddedToCartSuccessfulText());
    }

    @Step
    public void clickOnViewCart() {
        productPage.clickOnTheViewCartButton();
    }

    @Step
    public void checkItemIsInCart() {
        Assert.assertTrue(cartPage.isProductAddedSuccessful(adminAddProductPage.getProductNameMemo()));
    }

    @Step
    public void searchTheSecondItemWithTheProductPageSearchBarAndClickOnIt() {
        productPage.setSearchField(adminAddProductPage.getSecondProductNameMemo());
        searchResultsPage.clickOnTheItem(adminAddProductPage.getSecondProductNameMemo());
    }

    @Step
    public void searchTheThirdItemWithTheProductPageSearchBarAndClickOnIt() {
        productPage.setSearchField(adminAddProductPage.getThirdProductNameMemo());
        searchResultsPage.clickOnTheItem(adminAddProductPage.getThirdProductNameMemo());
    }

    @Step
    public void checkItemsAreAddedSuccessful() {
        Assert.assertTrue(cartPage.isProductAddedSuccessful(adminAddProductPage.getProductNameMemo()));
        Assert.assertTrue(cartPage.isProductAddedSuccessful(adminAddProductPage.getSecondProductNameMemo()));
        Assert.assertTrue(cartPage.isProductAddedSuccessful(adminAddProductPage.getThirdProductNameMemo()));
    }
}
