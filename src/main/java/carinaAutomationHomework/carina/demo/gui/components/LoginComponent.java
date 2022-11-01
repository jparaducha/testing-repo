package carinaAutomationHomework.carina.demo.gui.components;

import carinaAutomationHomework.carina.demo.gui.pages.YahooHomePage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginComponent extends AbstractUIObject {

    @FindBy(xpath = "//input[@id='login-username']")
    private ExtendedWebElement emailInput;
    @FindBy(xpath = "//span[contains(@class,'stay-signed-in')]//input[@type='checkbox']")
    private ExtendedWebElement staySignedIn;
    @FindBy(xpath = "//input[@id= 'login-signin']")
    private ExtendedWebElement logEmailButton;
    @FindBy(xpath = "//input[@id='login-passwd']")
    private ExtendedWebElement passwordInput;
    @FindBy(xpath = "//button[@id= 'login-signin']")
    private ExtendedWebElement loginButton;

    public LoginComponent (WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public YahooHomePage loginToPage (String email, String password) {
        emailInput.type(email);

        Actions act = new Actions(driver);
        act.moveToElement(staySignedIn.getElement()).click();

        logEmailButton.click();

        Assert.assertTrue(passwordInput.isElementPresent(), "password input is not present");

        passwordInput.type(password);
        loginButton.click();

        return new YahooHomePage(driver);
    }
}
