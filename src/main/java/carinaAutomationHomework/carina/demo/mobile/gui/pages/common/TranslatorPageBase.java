package carinaAutomationHomework.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class TranslatorPageBase extends AbstractPage {

    public TranslatorPageBase (WebDriver driver) {
        super(driver);
    }

    public abstract void validateBasicElements ();

    public abstract void validatePhraseBook ();

    public abstract void validateTranslation (String text, String language);
}
