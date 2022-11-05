package carinaAutomationHomework.carina.demo.mobile.gui.pages.android;

import carinaAutomationHomework.carina.demo.mobile.gui.pages.common.TranslatorPageBase;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = TranslatorPageBase.class)
public class TranslatorPage extends TranslatorPageBase {

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
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private ExtendedWebElement navigateUp;

    public TranslatorPage (WebDriver driver) {
        super(driver);
    }

    @Override
    public void validateBasicElements () {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(phraseBookButton.isElementPresent(5), "phrase book button is not present");
        softAssert.assertTrue(barLayout.isElementPresent(2), "bar layout is not present");
        softAssert.assertTrue(toolBar.isElementPresent(2), "tool bar is not present");
        softAssert.assertTrue(googleLogo.isElementPresent(2), "google logo is not shown");
        softAssert.assertAll("One or more elements didn't load");
    }

    @Override
    public void validatePhraseBook () {
        phraseBookButton.click();
        saved.assertElementPresent(5);
        //Assert.assertTrue(saved.isElementPresent(), "Saved element is not present");
    }
}
