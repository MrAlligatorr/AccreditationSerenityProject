package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.AdminLoginSteps;
import org.fasttrackit.utils.BaseTest;
import org.junit.Test;

public class AdminLoginTest extends BaseTest {

    @Steps
    private AdminLoginSteps adminLoginSteps;


    @Test
    public void adminLoginWithValidCredentials() {
        adminLoginSteps.navigateToAdminLogin();
        adminLoginSteps.setValidCredentials("admin", "parola11");
        adminLoginSteps.clickOnTheLoginButton();
        adminLoginSteps.checkAdminWelcomeText("Welcome to WordPress!");
    }
}
