package carinaAutomationHomework.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class YahooHomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//a[@id='ybar-logo']//img")
    private List<ExtendedWebElement> logoImages;
    @FindBy(xpath = "//div[@id='module-weather']//div[@id='grid-layout']")
    private ExtendedWebElement weatherBlock;
    @FindBy(xpath = "//input[@id='ybar-sbq']")
    private ExtendedWebElement searchBar;
    @FindBy(xpath = "//button[@id='ybar-search']")
    private ExtendedWebElement searchButton;
    @FindBy(xpath = "//div[@id='ybarAccountProfile']//a")
    private ExtendedWebElement loginButton;
    @FindBy(xpath = "//label[@id='ybarAccountMenuOpener']//span[contains(text(),'%s')]")
    private ExtendedWebElement userNameSpan;

    public YahooHomePage (WebDriver driver) {
        super(driver);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        setUiLoadedMarker(weatherBlock);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public void validateUIElements () {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(logoImages.get(0).isElementPresent(5), "logo is not shown");
        softAssert.assertTrue(weatherBlock.isElementPresent(5), "weather block is not present");
        softAssert.assertAll();
    }

    public void validateSearchBar () {
        searchBar.assertElementPresent(5);
        //Assert.assertTrue(searchBar.isElementPresent(5), "search bar is not present");
    }

    public void validateLoginBtn () {
        Assert.assertTrue(loginButton.isElementPresent(5), "login button is not present");
    }

    public WebDriver clickLoginButton () {
        loginButton.click();

        return driver;
    }

    public YahooSearchResults Search (String search) {

        searchBar.type(search);
        searchButton.click();
        return new YahooSearchResults(driver);
    }

    public void validateUserNameDisplay (String username) {

        userNameSpan.format(username).assertElementPresent(5);
    }
}