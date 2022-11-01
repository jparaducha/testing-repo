package carinaAutomationHomework.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class YahooSearchResults extends AbstractPage {
    @FindBy(xpath = "//li[@class='first']//a[contains(text(),'Últimas noticias')]")
    private ExtendedWebElement title;

    public YahooSearchResults (WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public void goBack () {
        driver.navigate().back();

        //return driver;
    }

    public void isNewsTitlePresent () {
        Assert.assertTrue(title.isElementPresent(), "latest news title is not present");
    }
}
