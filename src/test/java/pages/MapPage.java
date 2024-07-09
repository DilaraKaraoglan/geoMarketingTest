package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import shared.SharedMethods;

import java.time.Duration;

public class MapPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(how = How.XPATH, using = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0 MuiCard-root css-18rp9sd']")
    @CacheLookup
    public WebElement mapsGrid;

    @FindBy(how = How.XPATH, using = "//div[@test-id='left-menu-filter-btn']")
    @CacheLookup
    public WebElement leftMenuFilterButton;

    @FindBy(how = How.XPATH, using = "//h6[text()='Filtreler']")
    @CacheLookup
    public WebElement filterButton;

    public MapPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void mouseOverButton(WebElement webElement){
        SharedMethods sharedMethods = PageFactory.initElements(driver, SharedMethods.class);
        sharedMethods.mouseOverButton(webElement);
    }

    public void clickButton(WebElement webElement) {
        SharedMethods sharedMethods = PageFactory.initElements(driver, SharedMethods.class);
        sharedMethods.clickButton(webElement);
    }
}
