package org.example;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.MapPage;
import utilities.ConfigReader;

import java.time.Duration;

public class Maps {
    private ConfigReader configReader;
    private WebDriver driver;
    private Login login;

    public Maps() {
        this.login = new Login();
        this.configReader = new ConfigReader();
        this.driver = login.getDriver();
    }

    @Step("Set up configuration for maps")
    public void setUpConfig() {
        configReader = new ConfigReader();
    }

    @Step("Click maps grid")
    public void clickMapsGrid() {
        MapPage mapPage = PageFactory.initElements(driver, MapPage.class);
        mapPage.clickButton(mapPage.mapsGrid);
    }

    @Step("Click and hold filter button")
    public void clickAndHoldFilterButton() {
        MapPage mapPage = PageFactory.initElements(driver, MapPage.class);
        mapPage.mouseOverButton(mapPage.leftMenuFilterButton);
    }
    @Step("Click and hold layers button")
    public void clickAndHoldLayersButton() {
        MapPage mapPage = PageFactory.initElements(driver, MapPage.class);
        mapPage.mouseOverButton(mapPage.leftMenuLayersButton);
    }

    @Step("refresh")
    public void refresh(){
        driver.navigate().refresh();

    }
    @Step("turn onboarding")
    public void turnOnboarding(){
        MapPage mapPage = PageFactory.initElements(driver, MapPage.class);
        mapPage.clickButton(mapPage.menuElement);
    }
    @Step("Click filter button")
    public void clickFilterButton() {
        MapPage mapPage = PageFactory.initElements(driver, MapPage.class);
        mapPage.clickButton(mapPage.filterButton);
    }

    @Step("Click layers button")
    public void clickLayersButton() {
        MapPage mapPage = PageFactory.initElements(driver, MapPage.class);
        mapPage.clickButton(mapPage.layersButton);
    }

    @Step("Display IL")
    public void displayIL() throws InterruptedException {
        MapPage mapPage = PageFactory.initElements(driver, MapPage.class);
        mapPage.verifyDisplayed(mapPage.layerTextIL);
    }
    @Step("Display ILCE")
    public void displayILCE() throws InterruptedException {
        MapPage mapPage = PageFactory.initElements(driver, MapPage.class);
        mapPage.verifyDisplayed(mapPage.layerTextILCE);
    }

    @Step("Display Mahalle")
    public void displayMahalle() throws InterruptedException {
        MapPage mapPage = PageFactory.initElements(driver, MapPage.class);
        mapPage.verifyDisplayed(mapPage.layerTextMAHALLE);
    }
}
