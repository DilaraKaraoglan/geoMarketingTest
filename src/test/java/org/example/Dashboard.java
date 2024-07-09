package org.example;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.DashboardPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Dashboard {

    private ConfigReader configReader;
    private WebDriver driver;
    private Login login;

    public Dashboard() {
        this.login = new Login();
        this.configReader = new ConfigReader();
        this.driver = login.getDriver();
    }

    @Step("Set up configuration for dashboard")
    public void setUpConfig() {
        configReader = new ConfigReader();
    }

    @Step("Click 'Uygulamayı Başlat' button on dashboard")
    public void clickStartAppButton() {
        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        dashboardPage.clickStartAppButton();
    }
}
