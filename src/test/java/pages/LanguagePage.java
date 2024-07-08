package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LanguagePage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//button[text()='Türkçe']")
    @CacheLookup
    WebElement languageButtonFirst;
    @FindBy(how = How.XPATH, using = "//button[text()='English']")
    @CacheLookup
    WebElement languageButtonSecond;

    @FindBy(how = How.XPATH, using = "(//ul[@aria-label='Türkçe']//li[@role='menuitem'])[3]")
    @CacheLookup
    WebElement languageButtonENG;

    @FindBy(how = How.XPATH, using = "(//ul[@aria-label='English']//li[@role='menuitem'])[2]")
    @CacheLookup
    WebElement languageButtonTR;



    public LanguagePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLanguageButtonFirst() {
        languageButtonFirst.click();
    }
    public void clickLanguageButtonSecond() {
        languageButtonSecond.click();
    }
    public void clickLanguageButtonENG() {
        languageButtonENG.click();
    }
    public void clickLanguageButtonTR() {
        languageButtonTR.click();
    }
}
