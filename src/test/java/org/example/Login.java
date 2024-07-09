package org.example;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Login {
    private ConfigReader configReader;
    private static WebDriver driver;

    @Step("Set up configuration")
    public void setUpConfig() {
        configReader = new ConfigReader();
    }

    @Step("Start browser and open URL")
    public void startBrowserAndOpenURL() {
        driver = Driver.StartBrowser(configReader.getUrl());
        waitForPageToLoad();
    }

    @Step("Login to the website")
    public void loginToWebsite() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginToWebsite(configReader.getUsername(), configReader.getPassword());
        waitForPageToLoad();
    }

    public WebDriver getDriver() {
        return driver;
    }

    private void waitForPageToLoad() {
        try {
            Thread.sleep(2000); // Consider using WebDriverWait for better synchronization
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
