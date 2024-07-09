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

public class DashboardPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(how = How.XPATH, using = "//a[text()='Uygulamayı Başlat']")
    @CacheLookup
    private WebElement startAppButton;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickStartAppButton() {
        wait.until(ExpectedConditions.elementToBeClickable(startAppButton));
        startAppButton.click();
    }

    public boolean isStartAppButtonDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(startAppButton));
        return startAppButton.isDisplayed();
    }
}
