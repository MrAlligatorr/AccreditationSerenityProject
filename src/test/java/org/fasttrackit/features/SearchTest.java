package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.AdminAddProductSteps;
import org.fasttrackit.steps.SearchSteps;
import org.fasttrackit.utils.BaseTest;
import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class SearchTest extends BaseTest {

    @Steps
    private SearchSteps searchSteps;

    @Steps
    private AdminAddProductSteps adminAddProductSteps;


    @Test
    public void searchAProduct(){
        adminAddProductSteps.doAddProductInAdminAndLogOut(Constants.GENERATE_PRODUCT_NAME,Constants.GENERATE_PRICE);
        searchSteps.enterKeywordOnTheSearchBar();
        searchSteps.checkItemIsFound();
    }
}
