package org.example;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.MapPage;
import utilities.ConfigReader;

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
        mapPage.clickMapsGrid();
    }

    @Step("Click and hold filter button")
    public void clickAndHoldFilterButton() {
        MapPage mapPage = PageFactory.initElements(driver, MapPage.class);
        mapPage.mouseOverFilterButton();
    }

    @Step("Click filter button")
    public void clickFilterButton() {
        MapPage mapPage = PageFactory.initElements(driver, MapPage.class);
        mapPage.clickFilterButton();
    }
}
