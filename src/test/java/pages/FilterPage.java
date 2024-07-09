package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FilterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(how = How.XPATH, using = "//button[@test-id='create-new-filter-btn']")
    @CacheLookup
    private WebElement createFilterButton;

    @FindBy(how = How.XPATH, using = "//input[@id=':r16:']")
    @CacheLookup
    private WebElement selectCity;

    @FindBy(how = How.XPATH, using = "//input[@id=':r18:']")
    @CacheLookup
    private WebElement selectDistrict;

    @FindBy(how = How.XPATH, using = "//input[@id=':r2d:']")
    @CacheLookup
    private WebElement selectCriterion;

    @FindBy(how = How.XPATH, using = "//button[@id=':r1h:']")
    @CacheLookup
    private WebElement previewButton;

    @FindBy(how = How.XPATH, using = "//h6[text()='İdari Sınır']")
    @CacheLookup
    private WebElement pagePath;

    @FindBy(how = How.XPATH, using = "//label[.//span[text()='Konut_2022']]//input[@type='checkbox']")
    @CacheLookup
    private WebElement radioButton;

    @FindBy(how = How.XPATH, using = "//button[text()='İşlemler']")
    @CacheLookup
    private WebElement transactionsButton;

    @FindBy(how = How.XPATH, using = "//h6[text()='Filtreyi Kaydet']")
    @CacheLookup
    private WebElement saveFilterButton;

    public FilterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickCreateFilterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(createFilterButton)).click();
    }

    public void selectCityDropdown() {
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(selectCity));
        actions.click(selectCity)
                .sendKeys("ist")
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.ENTER)
                .perform();
    }

    public void selectDistrictDropdown() {
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(selectDistrict));
        actions.click(selectDistrict)
                .sendKeys("kad")
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.ENTER)
                .perform();
    }

    public void clickRadioButton() {
        Actions actions = new Actions(driver);

        // Scroll down a bit and then scroll up a little
        actions.sendKeys(pagePath, Keys.PAGE_DOWN)
                .sendKeys(Keys.ARROW_UP, Keys.ARROW_UP, Keys.ARROW_UP, Keys.ARROW_UP)
                .perform();

        // Wait for the page to stabilize
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        }

        // Click the radio button
        actions.moveToElement(radioButton).click().perform();
    }


    public void selectCriterion() {
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(selectCriterion));
        actions.click(selectCriterion)
                .sendKeys("büyükt")
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys("20000")
                .perform();
    }

    public void clickPreviewButton() {
        wait.until(ExpectedConditions.elementToBeClickable(previewButton)).click();
    }

    public void clickTransactionsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(transactionsButton)).click();
    }

    public void clickSaveFilterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveFilterButton)).click();
    }

    public void personalizeTheFilterButton() {
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(pagePath));
        actions.sendKeys("thirdFilter")
                .sendKeys(Keys.TAB)
                .sendKeys("#EAF251")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
    }
}
