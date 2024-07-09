package org.example;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.OnboardingPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Onboarding {
    private ConfigReader configReader;
    private WebDriver driver;
    private Login login;

    public Onboarding() {
        this.login = new Login();
        this.configReader = new ConfigReader();
        this.driver = login.getDriver();
    }

    @Step("Set up configuration for onboarding")
    public void setUpConfig() {
        configReader = new ConfigReader();
    }

    @Step("Click map button")
    public void clickMapButton() {
        OnboardingPage onboardingPage = PageFactory.initElements(driver, OnboardingPage.class);
        onboardingPage.clickMapButton();
    }
}
