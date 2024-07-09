package org.example;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.FilterPage;
import utilities.ConfigReader;

public class Filter {
    private ConfigReader configReader;
    private WebDriver driver;
    private Login login;

    public Filter() {
        this.login = new Login();
        this.configReader = new ConfigReader();
        this.driver = login.getDriver();
    }

    @Step("Set up configuration for filter")
    public void setUpConfig() {
        configReader = new ConfigReader();
    }

    @Step("Click create filter button")
    public void clickCreateFilterButton() {
        FilterPage filterPage = PageFactory.initElements(driver, FilterPage.class);
        filterPage.clickButton(filterPage.createFilterButton);
    }

    @Step("Select City")
    public void selectCity() {
        FilterPage filterPage = PageFactory.initElements(driver, FilterPage.class);
        filterPage.selectCityDropdown();
    }

    @Step("Select District")
    public void selectDistrict() {
        FilterPage filterPage = PageFactory.initElements(driver, FilterPage.class);
        filterPage.selectDistrictDropdown();
    }

    @Step("Click Radio Button")
    public void clickRadioButton() {
        FilterPage filterPage = PageFactory.initElements(driver, FilterPage.class);
        filterPage.clickRadioButton();
    }

    @Step("Select criterion and show review")
    public void clickCriterionButton() {
        FilterPage filterPage = PageFactory.initElements(driver, FilterPage.class);
        filterPage.selectCriterion();
        filterPage.clickButton(filterPage.previewButton);
    }

    @Step("Click Transactions Button")
    public void clickTransactionsButton() {
        FilterPage filterPage = PageFactory.initElements(driver, FilterPage.class);
        filterPage.clickButton(filterPage.transactionsButton);
    }

    @Step("Click Save Filter Button")
    public void clickSaveFilterButton() {
        FilterPage filterPage = PageFactory.initElements(driver, FilterPage.class);
        filterPage.clickButton(filterPage.saveFilterButton);
    }

    @Step("Personalize the filter button")
    public void personalizeTheFilterButton() {
        FilterPage filterPage = PageFactory.initElements(driver, FilterPage.class);
        filterPage.personalizeTheFilterButton();
    }
}
