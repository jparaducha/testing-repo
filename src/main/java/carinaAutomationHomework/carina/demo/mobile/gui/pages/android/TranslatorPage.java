package carinaAutomationHomework.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TranslatorPage extends AbstractPage implements IMobileUtils {

    @FindBy(xpath = "//android.widget.Button[@content-desc='Saved']")
    private ExtendedWebElement phraseBookButton;
    @FindBy(id = "com.google.android.apps.translate:id/app_bar_layout")
    private ExtendedWebElement barLayout;
    @FindBy(id = "com.google.android.apps.translate:id/toolbar")
    private ExtendedWebElement toolBar;
    @FindBy(id = "com.google.android.apps.translate:id/logo")
    private ExtendedWebElement googleLogo;
    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Saved']/android.view.ViewGroup")
    private ExtendedWebElement saved;

    public TranslatorPage (WebDriver driver) {
        super(driver);
    }

    public void isPhraseButtonPresent () {
        Assert.assertTrue(phraseBookButton.isElementPresent(), "phrase book button is not present");
    }

    public void isBarLayoutPresent () {
        Assert.assertTrue(barLayout.isElementPresent(), "bar layout is not present");
    }

    public void clickPhraseBook () {
        phraseBookButton.click();
        Assert.assertTrue(saved.isElementPresent(), "Saved element is not present");
    }

    public void isToolBarPresent () {
        Assert.assertTrue(toolBar.isElementPresent(), "tool bar is not present");
    }

    public void isLogoShown () {
        Assert.assertTrue(googleLogo.isElementPresent(), "google logo is not shown");
    }
}
