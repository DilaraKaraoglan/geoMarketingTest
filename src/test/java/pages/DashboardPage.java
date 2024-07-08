package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[text()='Uygulamayı Başlat']")
    @CacheLookup
    WebElement startAppButton;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickStartAppButton() {
        startAppButton.click();
    }
}
