package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.AdminAddProductSteps;
import org.fasttrackit.steps.AdminLogOutSteps;
import org.fasttrackit.steps.AdminLoginSteps;
import org.fasttrackit.steps.SearchSteps;
import org.fasttrackit.utils.BaseTest;
import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class SearchTest extends BaseTest {

    @Steps
    private SearchSteps searchSteps;

    @Steps
    private AdminLoginSteps adminLoginSteps;

    @Steps
    private AdminLogOutSteps adminLogOutSteps;

    @Steps
    private AdminAddProductSteps adminAddProductSteps;


    @Test
    public void searchAProduct(){
        adminLoginSteps.doAdminLogin();
        adminAddProductSteps.doAddProductFromAdmin(Constants.GENERATE_PRODUCT_NAME,Constants.GENERATE_PRICE);
        adminLogOutSteps.doLogOutAndGoBackToSiteHomepage();
        searchSteps.enterKeywordOnTheSearchBar();
        searchSteps.checkItemIsFound();
    }
}
