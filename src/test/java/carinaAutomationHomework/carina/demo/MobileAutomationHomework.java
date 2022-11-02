package carinaAutomationHomework.carina.demo;

import carinaAutomationHomework.carina.demo.mobile.gui.pages.android.TranslatorPage;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.annotations.Test;

public class MobileAutomationHomework implements IAbstractTest, IMobileUtils {

    @Test()
    @MethodOwner(owner = "paraducha")
    public void testLoadScreen () {
        TranslatorPage translatorPage = new TranslatorPage(getDriver());
        translatorPage.isPhraseButtonPresent();
        translatorPage.isBarLayoutPresent();
        translatorPage.isLogoShown();
    }

    @Test()
    @MethodOwner(owner = "paraducha")
    public void testOpenPhraseBook () {
        TranslatorPage translatorPage = new TranslatorPage(getDriver());

        translatorPage.clickPhraseBook();
    }
}
