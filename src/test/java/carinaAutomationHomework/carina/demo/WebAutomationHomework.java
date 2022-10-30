package carinaAutomationHomework.carina.demo;

import carinaAutomationHomework.carina.demo.gui.pages.YahooHomePage;
import carinaAutomationHomework.carina.demo.gui.pages.YahooLoginPage;
import carinaAutomationHomework.carina.demo.gui.pages.YahooSearchResults;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class WebAutomationHomework implements IAbstractTest {

    YahooHomePage yahooHomePage;
    YahooSearchResults yahooSearchResults;

    @BeforeSuite(description = "basic elements and search")
    public void beforeSuite () {
        yahooHomePage = new YahooHomePage(getDriver());
        yahooHomePage.open();
    }

    @Test(priority = 1)
    @MethodOwner(owner = "paraducha")
    @TestPriority(Priority.P1)
    public void testOpenPage () {
        //YahooHomePage yahooHomePage = new YahooHomePage(getDriver());
        //yahooHomePage.open();

        Assert.assertTrue(yahooHomePage.isPageOpened(), "home page is not opened");
    }

    @Test(priority = 2)
    @MethodOwner(owner = "paraducha")
    @TestPriority(Priority.P2)
    public void testLogoIsShown () {
        //YahooHomePage yahooHomePage = new YahooHomePage(getDriver());
        //yahooHomePage.open();

        Assert.assertTrue(yahooHomePage.getLogoImages().get(0).isElementPresent(), "logo is not shown");
    }

    @Test(priority = 2)
    @MethodOwner(owner = "paraducha")
    @TestPriority(Priority.P2)
    public void testWeatherBlockIsPresent () {
        //YahooHomePage yahooHomePage = new YahooHomePage(getDriver());
        //yahooHomePage.open();

        Assert.assertTrue(yahooHomePage.getWeatherBlock().isElementPresent(), "weather block is not present");
    }

    @Test(priority = 3)
    @MethodOwner(owner = "paraducha")
    @TestPriority(Priority.P3)
    public void testSearchSomething () throws InterruptedException {
        yahooHomePage.getSearchBar().isElementPresent();
        yahooSearchResults = yahooHomePage.typeIntoSearchBar("Federer");

        Assert.assertTrue(yahooSearchResults.getNewsTitle().isElementPresent(), "latest news title is not present");

        //yahooHomePage = YahooHomePage(yahooSearchResults.goBack());

        //Assert.assertTrue(yahooHomePage.getNewsTitle().isElementPresent(), "latest news title is not present");
    }

    @Test(priority = 4)
    @MethodOwner(owner = "paraducha")
    public void testLoginPage () {
        yahooSearchResults.goBack();
        Assert.assertTrue(yahooHomePage.getLoginButton().isElementPresent(), "login button is not present");

        YahooLoginPage yahooLoginPage = new YahooLoginPage(yahooHomePage.clickLoginButton());

        Assert.assertTrue(yahooLoginPage.getLoginBox().isElementPresent(), "login box is not present");
    }
}
