package carinaAutomationHomework.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class YahooHomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//a[@id='ybar-logo']//img")
    private List<ExtendedWebElement> logoImages;
    @FindBy(xpath = "//div[@id='module-weather']//div[@id='grid-layout']")
    private ExtendedWebElement weatherBlock;
    //@FindBy(id = "ybar-sbq")
    @FindBy(xpath = "//input[@id='ybar-sbq']")
    private ExtendedWebElement searchBar;
    @FindBy(xpath = "//button[@id='ybar-search']")
    private ExtendedWebElement searchButton;
    @FindBy(xpath = "//div[@id='ybarAccountProfile']//a")
    private ExtendedWebElement loginButton;

    public YahooHomePage (WebDriver driver) {
        super(driver);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        setUiLoadedMarker(weatherBlock);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public ExtendedWebElement getLoginButton () {
        return loginButton;
    }

    public WebDriver clickLoginButton () {
        loginButton.click();

        return driver;
    }

    public ExtendedWebElement getSearchButton () {
        return searchButton;
    }

    public ExtendedWebElement getSearchBar () {
        return searchBar;
    }

    public YahooSearchResults typeIntoSearchBar (String search) {

        searchBar.type(search);
        searchButton.click();
        return new YahooSearchResults(driver);
    }

    public List<ExtendedWebElement> getLogoImages () {
        return logoImages;
    }

    public ExtendedWebElement getWeatherBlock () {
        return weatherBlock;
    }
}