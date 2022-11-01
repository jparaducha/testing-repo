package carinaAutomationHomework.carina.demo;

import carinaAutomationHomework.carina.demo.gui.pages.YahooHomePage;
import carinaAutomationHomework.carina.demo.gui.pages.YahooLoginPage;
import carinaAutomationHomework.carina.demo.gui.pages.YahooSearchResults;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WebAutomationHomework implements IAbstractTest {

    @Test(priority = 1)
    @MethodOwner(owner = "paraducha")
    @TestPriority(Priority.P1)
    public void testOpenPage () {

        YahooHomePage yahooHomePage = new YahooHomePage(getDriver());
        yahooHomePage.open();
        Assert.assertTrue(yahooHomePage.isPageOpened(), "home page is not opened");

        yahooHomePage.isLogoLoaded();
    }

    @Test(priority = 2)
    @MethodOwner(owner = "paraducha")
    @TestPriority(Priority.P2)
    public void testWeatherBlockIsPresent () {
        YahooHomePage yahooHomePage = new YahooHomePage(getDriver());
        yahooHomePage.open();
        yahooHomePage.isWeatherBlockPresent();
    }

    @Test(priority = 3, dataProvider = "dataProvider")
    @MethodOwner(owner = "paraducha")
    @TestPriority(Priority.P3)
    public void testSearchSomething (String search) {
        YahooHomePage yahooHomePage = new YahooHomePage(getDriver());
        yahooHomePage.open();
        yahooHomePage.isSearchBarPresent();

        YahooSearchResults yahooSearchResults;
        yahooSearchResults = yahooHomePage.typeIntoSearchBar(search);

        yahooSearchResults.isNewsTitlePresent();
    }

    @Test(priority = 4)
    @MethodOwner(owner = "paraducha")
    public void testLoginPage () {
        YahooHomePage yahooHomePage = new YahooHomePage(getDriver());
        yahooHomePage.open();

        yahooHomePage.isLoginBtnPresent();
        YahooLoginPage yahooLoginPage = new YahooLoginPage(yahooHomePage.clickLoginButton());

        yahooLoginPage.isLoginBoxPresent();
    }

    @DataProvider()
    public Object[][] dataProvider () {

        Object[][] search = {{"Federer"}};

        return search;
    }
}
