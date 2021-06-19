package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.AdminLogOutSteps;
import org.fasttrackit.steps.AdminLoginSteps;
import org.fasttrackit.utils.BaseTest;
import org.junit.Test;

public class AdminLogOutTest extends BaseTest {

    @Steps
    private AdminLogOutSteps adminLogOutSteps;

    @Steps
    private AdminLoginSteps adminLoginSteps;


    @Test
    public void logOutFromAdmin() {
        adminLoginSteps.doAdminLogin();
        adminLogOutSteps.logOut();
        adminLogOutSteps.checkLoggedOutSuccessfulText("You are now logged out.");
    }
}
