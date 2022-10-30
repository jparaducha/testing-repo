package carinaAutomationHomework.carina.demo.gui.pages;

import carinaAutomationHomework.carina.demo.gui.components.FooterMenu;
import carinaAutomationHomework.carina.demo.gui.components.WeValuePrivacyAd;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "footmenu")
    private FooterMenu footerMenu;

    @FindBy(xpath = "//div[contains(@class, 'brandmenu-v2')]//a")
    private List<ExtendedWebElement> brandLinks;

    @FindBy(className = "news-column-index")
    private ExtendedWebElement newsColumn;
    @FindBy(xpath = "//a[@id='ybar-logo']//img")
    private List<WebElement> logoImages;
    @FindBy(xpath = "//div[@id='module-weather']//div[@id='grid-layout']")
    private WebElement weatherBlock;

    public HomePage (WebDriver driver) {
        super(driver);
        setUiLoadedMarker(newsColumn);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public List<WebElement> getLogoImages () {
        return logoImages;
    }

    public WebElement getWeatherBlock () {
        return weatherBlock;
    }

    public FooterMenu getFooterMenu () {
        return footerMenu;
    }

    public BrandModelsPage selectBrand (String brand) {
        LOGGER.info("selecting '" + brand + "' brand...");
        for (ExtendedWebElement brandLink : brandLinks) {
            String currentBrand = brandLink.getText();
            LOGGER.info("currentBrand: " + currentBrand);
            if (brand.equalsIgnoreCase(currentBrand)) {
                brandLink.click();
                return new BrandModelsPage(driver);
            }
        }
        throw new RuntimeException("Unable to open brand: " + brand);
    }

    public WeValuePrivacyAd getWeValuePrivacyAd () {
        return new WeValuePrivacyAd(driver);
    }
}
