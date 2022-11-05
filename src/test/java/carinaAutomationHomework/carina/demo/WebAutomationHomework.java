package carinaAutomationHomework.carina.demo;

import carinaAutomationHomework.carina.demo.gui.components.LoginComponent;
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
    public void testBasicElements () {

        YahooHomePage yahooHomePage = new YahooHomePage(getDriver());
        yahooHomePage.open();
        Assert.assertTrue(yahooHomePage.isPageOpened(), "home page is not opened");

        yahooHomePage.validateUIElements();
    }

    @Test(priority = 3, dataProvider = "dataProvider")
    @MethodOwner(owner = "paraducha")
    @TestPriority(Priority.P3)
    public void testSearchSomething (String search) {
        YahooHomePage yahooHomePage = new YahooHomePage(getDriver());
        yahooHomePage.open();
        yahooHomePage.validateSearchBar();

        YahooSearchResults yahooSearchResults;
        yahooSearchResults = yahooHomePage.Search(search);

        yahooSearchResults.isNewsTitlePresent();
    }

    @Test(priority = 4, dataProvider = "loginData")
    @MethodOwner(owner = "paraducha")
    public void testLoginUser (String email, String password, String username) {
        YahooHomePage yahooHomePage = new YahooHomePage(getDriver());
        yahooHomePage.open();

        yahooHomePage.validateLoginBtn();
        YahooLoginPage yahooLoginPage = new YahooLoginPage(yahooHomePage.clickLoginButton());

        yahooLoginPage.isLoginBoxPresent();
        LoginComponent loginComponent = yahooLoginPage.getLoginComponent();
        yahooHomePage = loginComponent.loginToPage(email, password);

        yahooHomePage.validateUserNameDisplay(username);
    }

    @DataProvider()
    public Object[][] dataProvider () {

        Object[][] search = {{"Federer"}};

        return search;
    }

    @DataProvider()
    public Object[][] loginData () {

        return new Object[][]{{"testingpurposes943@yahoo.com", "testwebtest", "Testing"}};
    }
}
