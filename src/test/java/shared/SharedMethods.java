package shared;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SharedMethods {
    private WebDriver driver;
    private WebDriverWait wait;

    public SharedMethods(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void clickButton(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public void mouseOverButton(WebElement webElement) {
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        actions.clickAndHold(webElement).perform();
    }
}
