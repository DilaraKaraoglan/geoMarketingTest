package org.example;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LanguagePage;
import utilities.ConfigReader;

public class Language {


    ConfigReader configReader;
    WebDriver driver;
    Login login = new Login();

    @Step("Set up configuration for dashboard")
    public void setUpConfig() {
        configReader = new ConfigReader();
    }

    @Step("Click 'TR' button")
    public void clicklanguageButtonFirst() throws InterruptedException {
        LanguagePage languagePage = PageFactory.initElements(login.getDriver(), LanguagePage.class);
        Thread.sleep(3000);
        languagePage.clickLanguageButtonFirst();
        Thread.sleep(2000);
    }
    @Step("Change Language to ENG")
    public void clicklanguageButtonENG() throws InterruptedException {
        LanguagePage languagePage = PageFactory.initElements(login.getDriver(), LanguagePage.class);
        Thread.sleep(3000);
        languagePage.clickLanguageButtonENG();
        Thread.sleep(3000);
    }
    @Step("Change Language to TR")
    public void clicklanguageButtonTR() throws InterruptedException {
        LanguagePage languagePage = PageFactory.initElements(login.getDriver(), LanguagePage.class);
        Thread.sleep(3000);
        languagePage.clickLanguageButtonTR();
        Thread.sleep(3000);
    }

    @Step("Click 'ENG' button")
    public void clicklanguageButtonSecond() throws InterruptedException {
        LanguagePage languagePage = PageFactory.initElements(login.getDriver(), LanguagePage.class);
        Thread.sleep(3000);
        languagePage.clickLanguageButtonSecond();
        Thread.sleep(3000);
    }
}
