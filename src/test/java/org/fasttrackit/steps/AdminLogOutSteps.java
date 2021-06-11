package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.AdminHomepage;
import org.fasttrackit.pages.AdminLoginPage;
import org.fasttrackit.pages.HomePage;
import org.junit.Assert;

public class AdminLogOutSteps {

    private AdminHomepage adminHomepage;
    private AdminLoginPage adminLoginPage;
    private HomePage homePage;

    @Step
    public void logOut() {
        adminHomepage.hoverOnTheProfileAdminButton();
        adminHomepage.clickOnTheLogOutButton();
    }

    @Step
    public void checkLoggedOutSuccessfulText(String value) {
        Assert.assertEquals("Message does not match!",value, adminLoginPage.getLogOutText());
    }

    @Step
    public void doLogOutAndGoBackToSiteHomepage(){
        adminHomepage.hoverOnTheProfileAdminButton();
        adminHomepage.clickOnTheLogOutButton();
        adminLoginPage.clickOnTheBackToSiteButton();
    }
}
