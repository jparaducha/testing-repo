package carinaAutomationHomework.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooSearchResults extends AbstractPage {
    @FindBy(xpath = "//li[@class='first']//a[contains(text(),'Últimas noticias')]")
    private ExtendedWebElement title;

    public YahooSearchResults (WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public ExtendedWebElement getNewsTitle () {
        return title;
    }

    public void goBack () {
        driver.navigate().back();

        //return driver;
    }
}
