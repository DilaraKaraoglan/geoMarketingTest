package org.example;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.FilterPage;
import pages.MapPage;
import utilities.ConfigReader;

public class Filter {
    ConfigReader configReader;
    WebDriver driver;
    Login login = new Login();

    @Step("Set up configuration for dashboard")
    public void setUpConfig() {
        configReader = new ConfigReader();
    }



    @Step("Click create filter button")
    public void clickCreateFilterButton() throws InterruptedException{
        FilterPage filterPage = PageFactory.initElements(login.getDriver(),FilterPage.class);
        Thread.sleep(3000);
        filterPage.clickCreateFilterButton();
        Thread.sleep(3000);
    }

    @Step("Select City")
    public void selectCity() throws InterruptedException{
        FilterPage filterPage = PageFactory.initElements(login.getDriver(),FilterPage.class);
        Thread.sleep(3000);
        filterPage.selectCityDropdown();
        Thread.sleep(3000);
    }

    @Step("Select District")
    public void selectDistrict() throws InterruptedException{
        FilterPage filterPage = PageFactory.initElements(login.getDriver(),FilterPage.class);
        Thread.sleep(3000);
        filterPage.selectDistrictDropdown();
        Thread.sleep(3000);
    }

    @Step("Click Radio Button")
    public void clickRadioButton() throws InterruptedException{
        FilterPage filterPage = PageFactory.initElements(login.getDriver(),FilterPage.class);
        Thread.sleep(3000);
        filterPage.clickRadioButton();
        Thread.sleep(3000);
    }
    @Step("Select criterion and show review")
    public void clickCriterionButton() throws InterruptedException{
        FilterPage filterPage = PageFactory.initElements(login.getDriver(),FilterPage.class);
        Thread.sleep(3000);
        filterPage.selectCriterion();
        Thread.sleep(3000);
        filterPage.clickPreviewButton();
        Thread.sleep(2000);

    }
    @Step("Click Transactions Button")
    public void clickTransactionsButton() throws InterruptedException{
        FilterPage filterPage = PageFactory.initElements(login.getDriver(),FilterPage.class);
        Thread.sleep(3000);
        filterPage.clickTransactionsButton();
        Thread.sleep(3000);
    }

    @Step("Click Save Filter Button")
    public void clickSaveFilterButton() throws InterruptedException{
        FilterPage filterPage = PageFactory.initElements(login.getDriver(),FilterPage.class);
        Thread.sleep(3000);
        filterPage.clickSaveFilterButton();
        Thread.sleep(3000);
    }

    @Step("Personalize the filter button")
    public void personalizeTheFilterButton() throws InterruptedException{
        FilterPage filterPage = PageFactory.initElements(login.getDriver(),FilterPage.class);
        Thread.sleep(3000);
        filterPage.personalizeTheFilterButton();
        Thread.sleep(3000);
    }
}
