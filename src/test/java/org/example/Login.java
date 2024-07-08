package org.example;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

public class Login {
    ConfigReader configReader = new ConfigReader();
    static WebDriver driver;

    @Step("Set up configuration")
    public void setUpConfig() {
        configReader = new ConfigReader();
    }

    @Step("Start browser and open URL")
    public void startBrowserAndOpenURL() throws InterruptedException {
        driver = Driver.StartBrowser(configReader.getUrl());
        Thread.sleep(2000);
    }

    @Step("Login to the website")
    public void loginToWebsite() throws InterruptedException {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginToWebsite(configReader.getUsername(), configReader.getPassword());
        Thread.sleep(2000);
    }

    public WebDriver getDriver() {
        return driver;
    }


}

