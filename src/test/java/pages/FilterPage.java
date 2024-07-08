package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;

public class FilterPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//button[@test-id='create-new-filter-btn']")
    @CacheLookup
    WebElement createFilterButton;

    @FindBy(how = How.XPATH, using = "//input[@id=':r16:']")
    @CacheLookup
    WebElement selectCity;

    @FindBy(how = How.XPATH, using = "//input[@id=':r18:']")
    @CacheLookup
    WebElement selectDistrict;

    @FindBy(how = How.XPATH, using = "//input[@id=':r2d:']")
    @CacheLookup
    WebElement selectCriterion;

    @FindBy(how = How.XPATH, using = "//button[@id=':r1h:']")
    @CacheLookup
    WebElement previewButton;

    @FindBy(how = How.XPATH, using = "//h6[text()='İdari Sınır']")
    @CacheLookup
    WebElement pagePath;

    @FindBy(how = How.XPATH, using = "//label[.//span[text()='Konut_2022']]//input[@type='checkbox']")
    @CacheLookup
    WebElement radioButton;


    @FindBy(how = How.XPATH, using = "//button[text()='İşlemler']")
    @CacheLookup
    WebElement transactionsButton;

    @FindBy(how = How.XPATH, using = "//h6[text()='Filtreyi Kaydet']")
    @CacheLookup
    WebElement saveFilterButton;



    public FilterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCreateFilterButton() {
        createFilterButton.click();
    }
    public  void selectCityDropdown(){
        Actions actions = new Actions(driver);
        actions.click(selectCity)
                .sendKeys("ist")
                .keyDown(Keys.DOWN)
                .keyUp(Keys.DOWN)
                .sendKeys(Keys.ENTER)
                .perform();
    }

    public  void selectDistrictDropdown(){
        Actions actions = new Actions(driver);
        actions.click(selectDistrict)
                .sendKeys("kad")
                .keyDown(Keys.DOWN)
                .keyUp(Keys.DOWN)
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

    public void selectCriterion(){
        Actions actions = new Actions(driver);
        actions.click(selectCriterion)
                .sendKeys("büyükt")
                .keyDown(Keys.DOWN)
                .keyUp(Keys.DOWN)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys("20000")
                .perform();
    }

    public void clickPreviewButton(){
        Actions actions  =  new Actions(driver);
        actions.click(previewButton)
                .perform();
    }

    public void clickTransactionsButton(){
        Actions actions  =  new Actions(driver);
        actions.click(transactionsButton)
                .perform();
    }

    public void clickSaveFilterButton(){
        Actions actions  =  new Actions(driver);
        actions.click(saveFilterButton)
                .perform();
    }

    public void personalizeTheFilterButton(){
        Actions actions  =  new Actions(driver);
        actions.sendKeys("thirdFilter")
                .sendKeys(Keys.TAB)
                .sendKeys("#EAF251")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
    }


}