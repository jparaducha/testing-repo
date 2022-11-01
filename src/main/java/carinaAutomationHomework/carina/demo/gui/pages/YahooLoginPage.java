package carinaAutomationHomework.carina.demo.gui.pages;

import carinaAutomationHomework.carina.demo.gui.components.LoginComponent;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class YahooLoginPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='login-box-container']")
    private LoginComponent loginBox;

    public YahooLoginPage (WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public void isLoginBoxPresent () {
        Assert.assertTrue(loginBox.isUIObjectPresent(), "login box is not present");
    }

    public LoginComponent getLoginComponent () {
        return loginBox;
    }
}
