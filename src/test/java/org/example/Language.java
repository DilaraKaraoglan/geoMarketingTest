package org.example;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LanguagePage;
import utilities.ConfigReader;

public class Language {

    private ConfigReader configReader;
    private WebDriver driver;
    private Login login;

    public Language() {
        this.configReader = new ConfigReader();
        this.login = new Login();
        this.driver = login.getDriver();
    }

    @Step("Set up configuration for dashboard")
    public void setUpConfig() {
        configReader = new ConfigReader();
    }

    @Step("Click 'TR' button")
    public void clickLanguageButtonFirst() throws InterruptedException {
        LanguagePage languagePage = PageFactory.initElements(driver, LanguagePage.class);
        languagePage.clickLanguageButtonFirst();
    }

    @Step("Change Language to ENG")
    public void changeLanguageToENG() throws InterruptedException {
        LanguagePage languagePage = PageFactory.initElements(driver, LanguagePage.class);
        languagePage.clickLanguageButtonENG();
    }

    @Step("Change Language to TR")
    public void changeLanguageToTR() throws InterruptedException {
        LanguagePage languagePage = PageFactory.initElements(driver, LanguagePage.class);
        languagePage.clickLanguageButtonTR();
    }

    @Step("Click 'ENG' button")
    public void clickLanguageButtonSecond() throws InterruptedException {
        LanguagePage languagePage = PageFactory.initElements(driver, LanguagePage.class);
        languagePage.clickLanguageButtonSecond();
    }
}
