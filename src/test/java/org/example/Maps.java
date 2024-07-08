package org.example;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.MapPage;
import utilities.ConfigReader;

public class Maps {
    ConfigReader configReader;
    WebDriver driver;
    Login login = new Login();

    @Step("Set up configuration for dashboard")
    public void setUpConfig() {
        configReader = new ConfigReader();
    }

    @Step("Click maps grid")
    public void clickMapsGrid() throws InterruptedException {
        MapPage mapPage = PageFactory.initElements(login.getDriver(), MapPage.class);
        Thread.sleep(3000);
        mapPage.clickMapsGrid();
        Thread.sleep(3000);
    }
    @Step("Click and hold filter button")
    public void clickAndHoldFilterButton() throws InterruptedException{
        MapPage mapPage = PageFactory.initElements(login.getDriver(),MapPage.class);
        Thread.sleep(3000);
        mapPage.mouseOverFilterButton();
        Thread.sleep(3000);
    }
    @Step("Click filter button")
    public void clickFilterButton() throws InterruptedException{
        MapPage mapPage = PageFactory.initElements(login.getDriver(),MapPage.class);
        Thread.sleep(3000);
        mapPage.clickFilterButton();
        Thread.sleep(3000);
    }

}
