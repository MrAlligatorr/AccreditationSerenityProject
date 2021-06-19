package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.*;
import org.fasttrackit.utils.BaseTest;
import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class AddToCartTest extends BaseTest {

    @Steps
    private SearchSteps searchSteps;

    @Steps
    private AddToCartSteps productDetailsSteps;

    @Steps
    private AdminAddProductSteps adminAddProductSteps;


    @Test
    public void addItemToCart(){
        adminAddProductSteps.doAddProductInAdminAndLogOut(Constants.GENERATE_PRODUCT_NAME,Constants.GENERATE_PRICE);
        searchSteps.doSearchAnItemAndClickOnIt();
        productDetailsSteps.clickOnAddToCart();
        productDetailsSteps.checkForAddedSuccessfulText("“","” has been added to your cart.");
        productDetailsSteps.clickOnViewCart();
        productDetailsSteps.checkItemIsInCart();
    }
}
