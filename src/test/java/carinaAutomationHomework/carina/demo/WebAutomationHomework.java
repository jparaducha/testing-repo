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
import org.testng.annotations.DataProvider;
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

        Assert.assertTrue(yahooHomePage.isPageOpened(), "home page is not opened");
    }

    @Test(priority = 2)
    @MethodOwner(owner = "paraducha")
    @TestPriority(Priority.P2)
    public void testLogoIsShown () {

        Assert.assertTrue(yahooHomePage.getLogoImages().get(0).isElementPresent(), "logo is not shown");
    }

    @Test(priority = 2)
    @MethodOwner(owner = "paraducha")
    @TestPriority(Priority.P2)
    public void testWeatherBlockIsPresent () {

        Assert.assertTrue(yahooHomePage.getWeatherBlock().isElementPresent(), "weather block is not present");
    }

    @Test(priority = 3, dataProvider = "dataProvider")
    @MethodOwner(owner = "paraducha")
    @TestPriority(Priority.P3)
    public void testSearchSomething (String search) {
        yahooHomePage.getSearchBar().isElementPresent();
        yahooSearchResults = yahooHomePage.typeIntoSearchBar(search);

        Assert.assertTrue(yahooSearchResults.getNewsTitle().isElementPresent(), "latest news title is not present");

        //yahooHomePage = YahooHomePage(yahooSearchResults.goBack());
    }

    @Test(priority = 4)
    @MethodOwner(owner = "paraducha")
    public void testLoginPage () {
        yahooSearchResults.goBack();
        Assert.assertTrue(yahooHomePage.getLoginButton().isElementPresent(), "login button is not present");

        YahooLoginPage yahooLoginPage = new YahooLoginPage(yahooHomePage.clickLoginButton());

        Assert.assertTrue(yahooLoginPage.getLoginBox().isElementPresent(), "login box is not present");
    }

    @DataProvider()
    public Object[][] dataProvider () {

        Object[][] search = {{"Federer"}};

        return search;
    }
}
