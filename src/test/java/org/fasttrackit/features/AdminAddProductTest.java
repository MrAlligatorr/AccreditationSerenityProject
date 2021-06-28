package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.AdminAddProductSteps;
import org.fasttrackit.steps.AdminLoginSteps;
import org.fasttrackit.utils.BaseTest;
import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class AdminAddProductTest extends BaseTest {

    @Steps
    private AdminLoginSteps adminLoginSteps;

    @Steps
    private AdminAddProductSteps adminAddProductSteps;


    @Test
    public void addProductToTheCatalog() {
        adminLoginSteps.doAdminLogin();
        adminAddProductSteps.navigateToAddProductPage();
        adminAddProductSteps.setProductName(Constants.GENERATE_PRODUCT_NAME);
        adminAddProductSteps.setProductRegularPrice(Constants.GENERATE_PRICE);
        adminAddProductSteps.addItem();
        adminAddProductSteps.checkProductPublishedText("Product published. View Product");
    }

    @Test
    public void add2productsToTheCatalog() {
        adminLoginSteps.doAdminLogin();
        adminAddProductSteps.navigateToAddProductPage();
        adminAddProductSteps.setProductName(Constants.GENERATE_PRODUCT_NAME);
        adminAddProductSteps.setProductRegularPrice(Constants.GENERATE_PRICE);
        adminAddProductSteps.addItem();
        adminAddProductSteps.checkProductPublishedText("Product published. View Product");
        adminAddProductSteps.clickOnAddNewButton();
        adminAddProductSteps.setProductName(Constants.GENERATE_PRODUCT_NAME);
        adminAddProductSteps.setProductRegularPrice(Constants.GENERATE_PRICE);
        adminAddProductSteps.addItem();
        adminAddProductSteps.checkProductPublishedText("Product published. View Product");
    }
}
