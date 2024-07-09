package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import shared.SharedMethods;

import java.time.Duration;

public class LanguagePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(how = How.XPATH, using = "//button[text()='Türkçe']")
    @CacheLookup
    public WebElement languageButtonFirst;

    @FindBy(how = How.XPATH, using = "//button[text()='English']")
    @CacheLookup
    public WebElement languageButtonSecond;

    @FindBy(how = How.XPATH, using = "(//ul[@aria-label='Türkçe']//li[@role='menuitem'])[3]")
    @CacheLookup
    public WebElement languageButtonENG;

    @FindBy(how = How.XPATH, using = "(//ul[@aria-label='English']//li[@role='menuitem'])[2]")
    @CacheLookup
    public WebElement languageButtonTR;

    public LanguagePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Increased wait time to 20 seconds
        PageFactory.initElements(driver, this);
    }

    public void clickButton(WebElement webElement) throws InterruptedException {
        SharedMethods sharedMethods = PageFactory.initElements(driver, SharedMethods.class);
        waitForElementToBeClickable(webElement);
        sharedMethods.clickButton(webElement);
    }

    private void waitForElementToBeClickable(WebElement element) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Thread.sleep(500);  // Additional sleep to ensure stability
    }
}
