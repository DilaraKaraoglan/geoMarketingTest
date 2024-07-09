package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LanguagePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(how = How.XPATH, using = "//button[text()='Türkçe']")
    @CacheLookup
    private WebElement languageButtonFirst;

    @FindBy(how = How.XPATH, using = "//button[text()='English']")
    @CacheLookup
    private WebElement languageButtonSecond;

    @FindBy(how = How.XPATH, using = "(//ul[@aria-label='Türkçe']//li[@role='menuitem'])[3]")
    @CacheLookup
    private WebElement languageButtonENG;

    @FindBy(how = How.XPATH, using = "(//ul[@aria-label='English']//li[@role='menuitem'])[2]")
    @CacheLookup
    private WebElement languageButtonTR;

    public LanguagePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Increased wait time to 20 seconds
        PageFactory.initElements(driver, this);
    }

    public void clickLanguageButtonFirst() throws InterruptedException {
        waitForElementToBeClickable(languageButtonFirst);
        languageButtonFirst.click();
    }

    public void clickLanguageButtonSecond() throws InterruptedException {
        waitForElementToBeClickable(languageButtonSecond);
        languageButtonSecond.click();
    }

    public void clickLanguageButtonENG() throws InterruptedException {
        waitForElementToBeClickable(languageButtonENG);
        languageButtonENG.click();
    }

    public void clickLanguageButtonTR() throws InterruptedException {
        waitForElementToBeClickable(languageButtonTR);
        languageButtonTR.click();
    }

    private void waitForElementToBeClickable(WebElement element) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Thread.sleep(500);  // Additional sleep to ensure stability
    }
}
