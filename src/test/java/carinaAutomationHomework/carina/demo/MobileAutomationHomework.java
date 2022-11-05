package carinaAutomationHomework.carina.demo;

import carinaAutomationHomework.carina.demo.mobile.gui.pages.common.TranslatorPageBase;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MobileAutomationHomework implements IAbstractTest, IMobileUtils {

    @Test()
    @MethodOwner(owner = "paraducha")
    public void testLoadScreen () {
        TranslatorPageBase translatorPage = initPage(getDriver(), TranslatorPageBase.class);
        translatorPage.validateBasicElements();
    }

    @Test()
    @MethodOwner(owner = "paraducha")
    public void testOpenPhraseBook () {
        TranslatorPageBase translatorPage = initPage(getDriver(), TranslatorPageBase.class);

        translatorPage.validatePhraseBook();
    }

    @Test(dataProvider = "textToTranslate")
    @MethodOwner(owner = "paraducha")
    public void testTranslations (String text, String language) {
        TranslatorPageBase translatorPage = initPage(getDriver(), TranslatorPageBase.class);

        translatorPage.validateTranslation(text, language);
    }

    @DataProvider
    public Object[][] textToTranslate () {
        return new Object[][]{{"Merci beaucoup pour votre cadeau", "French"}, {"Far d’una mosca un elefante", "Italian"}};
    }
}
