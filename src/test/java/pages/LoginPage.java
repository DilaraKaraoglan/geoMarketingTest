package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertTrue;

public class LoginPage {

    WebDriver driver;

    @FindBy(how= How.XPATH, using = "//input[@name='username']")
    @CacheLookup
    WebElement userNamePath;

    @FindBy(how = How.XPATH, using = "//input[@name='password']")
    @CacheLookup
    WebElement passwordPath;
    @FindBy(how = How.XPATH, using = "//button[@test-id='login-submit']")
    @CacheLookup
    WebElement loginButton;


    public void verifyDisplayed(String text, String webElementPath) {
        WebElement webElement = driver.findElement(By.xpath(webElementPath));
        assertTrue(webElement.isDisplayed());
        System.out.println("Text is displayed " + webElement.getText());
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginToWebsite(String username, String password) {
        userNamePath.sendKeys(username);
        passwordPath.sendKeys(password);
        loginButton.click();
    }

}
