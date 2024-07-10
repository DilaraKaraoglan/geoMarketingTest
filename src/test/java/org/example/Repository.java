package org.example;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.OnboardingPage;
import pages.RepositoryPage;
import utilities.ConfigReader;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Repository {

    private final ConfigReader configReader;
    private final WebDriver driver;

    public Repository() {
        Login login = new Login();
        this.configReader = new ConfigReader();
        this.driver = login.getDriver();
    }

    @Step("Click dataset button")
    public void clickDatasetButton() {
        RepositoryPage repositoryPage = PageFactory.initElements(driver, RepositoryPage.class);
        repositoryPage.clickButton(repositoryPage.dataset);
    }



    @Step("Click base layer button")
    public void clickBaseLayerGrid() {
        RepositoryPage repositoryPage = PageFactory.initElements(driver, RepositoryPage.class);
        repositoryPage.clickButton(repositoryPage.baseLayerGrid);
    }

    @Step("Click Administrator Area button")
    public void clickAdministratorAreaGrid() {
        RepositoryPage repositoryPage = PageFactory.initElements(driver, RepositoryPage.class);
        repositoryPage.clickButton(repositoryPage.administratorAreaGrid);
    }
    @Step("Select file uploud button")
    public void selectFileForUploudButton() throws InterruptedException, AWTException {
        String filePath = configReader.getPathForCity(); // Assuming this returns the correct file path
        RepositoryPage repositoryPage = PageFactory.initElements(driver, RepositoryPage.class);
        repositoryPage.clickFileUploudButton(filePath);
        System.out.println(filePath);
    }

    @Step("Click continue button")
    public void clickContinueButton() {
        RepositoryPage repositoryPage = PageFactory.initElements(driver, RepositoryPage.class);
        repositoryPage.clickButton(repositoryPage.continueButton);
    }

    @Step("Click survey data button")
    public void clickSurveyDataButton() {
        RepositoryPage repositoryPage = PageFactory.initElements(driver, RepositoryPage.class);
        repositoryPage.clickButton(repositoryPage.surveyDataButton);
    }



}
