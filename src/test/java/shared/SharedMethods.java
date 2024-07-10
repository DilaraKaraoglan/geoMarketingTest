package shared;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

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

    public void verifyDisplayedWithRetry(WebElement webElement,WebElement layerButton , WebElement leftMenuLayer, int maxRetries, Duration retryInterval) {
        for (int i = 0; i < maxRetries; i++) {
            try {
                wait.until(ExpectedConditions.visibilityOf(webElement));
                if (webElement.isDisplayed()) {
                    System.out.println("Text is displayed: " + webElement.getText() + " " + webElement.isDisplayed());
                    return;
                }
            } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
                driver.navigate().refresh();
                mouseOverButton(leftMenuLayer);
                clickButton(layerButton);
                try {
                    Thread.sleep(retryInterval.toMillis());
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        assertTrue("Element is not displayed after retries: " + webElement.toString(), webElement.isDisplayed());
    }
}
