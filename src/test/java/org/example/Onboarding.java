package org.example;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.OnboardingPage;
import utilities.ConfigReader;

public class Onboarding {
    ConfigReader configReader;
    WebDriver driver;
    Login login = new Login();

    @Step("Set up configuration for dashboard")
    public void setUpConfig() {
        configReader = new ConfigReader();
    }

    @Step("Click map button")
    public void clickMapButton() throws InterruptedException {
        OnboardingPage onboardingPage = PageFactory.initElements(login.getDriver(), OnboardingPage.class);
        Thread.sleep(3000);
        onboardingPage.clickMapButton();
        Thread.sleep(3000);
    }

}
