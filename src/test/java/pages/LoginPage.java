package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(how = How.XPATH, using = "//input[@name='username']")
    @CacheLookup
    private WebElement userNamePath;

    @FindBy(how = How.XPATH, using = "//input[@name='password']")
    @CacheLookup
    private WebElement passwordPath;

    @FindBy(how = How.XPATH, using = "//button[@test-id='login-submit']")
    @CacheLookup
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    public void verifyDisplayed(String text, String webElementPath) {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(webElementPath)));
        assertTrue(webElement.isDisplayed());
        System.out.println("Text is displayed: " + webElement.getText());
    }

    public void loginToWebsite(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(userNamePath)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(passwordPath)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
}
