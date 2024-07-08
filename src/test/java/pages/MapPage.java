package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MapPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0 MuiCard-root css-18rp9sd']")
    @CacheLookup
    WebElement mapsGrid;

    @FindBy(how = How.XPATH, using = "//div[@test-id='left-menu-filter-btn']")
    @CacheLookup
    WebElement leftMenuFilterButton;

    @FindBy(how = How.XPATH, using = "//h6[text()='Filtreler']")
    @CacheLookup
    WebElement filterButton;

    public MapPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickMapsGrid() {
        mapsGrid.click();
    }

    public void mouseOverFilterButton(){
        Actions actions = new Actions(driver);
        actions.clickAndHold(leftMenuFilterButton).perform();
    }
    public void clickFilterButton() {
        filterButton.click();
    }

}
