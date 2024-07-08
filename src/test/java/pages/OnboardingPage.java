package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OnboardingPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//button[@aria-label='Haritalar']")
    @CacheLookup
    WebElement mapButton;

    public OnboardingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickMapButton() {
        mapButton.click();
    }
}
