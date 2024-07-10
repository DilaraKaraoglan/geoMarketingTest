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
import shared.SharedMethods;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.security.Key;
import java.time.Duration;

public class RepositoryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public RepositoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//h6[@class='MuiTypography-root MuiTypography-subtitle2 css-1cpg3ij']")
    @CacheLookup
    public WebElement dataset;

    @FindBy(how = How.XPATH, using = "//img[@test-id='fileUpload']")
    @CacheLookup
    public WebElement fileUploudButton;

    @FindBy(how = How.XPATH, using = "//h6[text()='Releated To Base Layer']")
    @CacheLookup
    public WebElement baseLayerGrid;

    @FindBy(how = How.XPATH, using = "//h6[text()='Administrator Area']")
    @CacheLookup
    public WebElement administratorAreaGrid;

    @FindBy(how = How.XPATH, using = "//input[@type='url']")
    @CacheLookup
    public WebElement uploudWithLinkInput;

    @FindBy(how = How.XPATH, using = "//button[text()='Devam Et']")
    @CacheLookup
    public WebElement continueButton;

    @FindBy(how = How.XPATH, using = "//h6[text()='Survey Data']")
    @CacheLookup
    public WebElement surveyDataButton;

    @FindBy(how = How.XPATH, using = "//p[text()='Kolonları Seçin']/parent::div/div[@class='MuiStack-root css-1b0zbwx']")
    @CacheLookup
    public WebElement selectColons;

    @FindBy(how = How.XPATH, using = "//option[text()='ID Kolonunu Seçiniz']")
    @CacheLookup
    public WebElement selectIDColon;

    public void clickButton(WebElement webElement) {
        SharedMethods sharedMethods = PageFactory.initElements(driver, SharedMethods.class);
        sharedMethods.clickButton(webElement);
    }



    public void clickFileUploudButton(String pathForFile) throws InterruptedException, AWTException {
        wait.until(ExpectedConditions.elementToBeClickable(fileUploudButton));
        fileUploudButton.click();
        selectFileForUploudTab(uploudWithLinkInput, pathForFile);
    }

    public void selectFileForUploudTab(WebElement webElement, String pathForFile) throws InterruptedException, AWTException {
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        actions.click(webElement)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(2000);
        selectFileRobot(pathForFile);

    }
    public void selectFileRobot(String path) throws InterruptedException, AWTException {

        StringSelection photo = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(photo, null);
        Thread.sleep(5000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void selectColonsForCity(String idColon, String aliasColon, String displayname){
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(selectColons));
        actions.click(selectIDColon)
                .sendKeys(idColon)
                .sendKeys(Keys.TAB)
                .sendKeys(aliasColon)
                .sendKeys(displayname)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
    }

    public void selectColonsForDistrict(String idColon, String aliasColon, String displayname, String parent){
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(selectColons));
        actions.click(selectIDColon)
                .sendKeys(idColon)
                .sendKeys(Keys.TAB)
                .sendKeys(parent)
                .sendKeys(Keys.TAB)
                .sendKeys(aliasColon)
                .sendKeys(Keys.TAB)
                .sendKeys(displayname)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
    }

    public void selectColonsForIlce(){
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(selectColons));
        actions.click(selectIDColon)
                .sendKeys("PLA")
                .sendKeys(Keys.TAB)
                .sendKeys("IL")
                .sendKeys("il_region")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
    }


}
