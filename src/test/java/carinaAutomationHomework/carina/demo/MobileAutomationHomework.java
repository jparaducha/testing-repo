package carinaAutomationHomework.carina.demo;

import carinaAutomationHomework.carina.demo.mobile.gui.pages.common.TranslatorPageBase;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
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
}
