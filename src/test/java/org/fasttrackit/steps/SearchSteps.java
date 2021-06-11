package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.*;
import org.junit.Assert;

public class SearchSteps {

    private AdminLoginPage adminLoginPage;
    private AdminAddProductPage adminAddProductPage;
    private HomePage homePage;
    private AdminHomepage adminHomepage;
    private SearchResultsPage searchResultsPage;


    @Step
    public void enterKeywordOnTheSearchBar() {
        homePage.setSearchBarTextField(adminAddProductPage.getProductNameMemo());
    }

    @Step
    public void checkItemIsFound(){
        Assert.assertTrue("Item not found!", searchResultsPage.checkItemIsFound(adminAddProductPage.getProductNameMemo()));
    }

    @Step
    public void doSearchAnItemAndClickOnIt(){
        homePage.setSearchBarTextField(adminAddProductPage.getProductNameMemo());
        searchResultsPage.clickOnTheItem(adminAddProductPage.getProductNameMemo());
    }

    @Step
    public void clickOnTheProduct(){
        searchResultsPage.clickOnTheItem(adminAddProductPage.getProductNameMemo());
    }

}
