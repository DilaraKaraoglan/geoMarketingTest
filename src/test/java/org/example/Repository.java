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
    @Step("Select file uploud for city")
    public void selectFileForUploudCityButton() throws InterruptedException, AWTException {
        String filePath = configReader.getDataPathIL(); // Assuming this returns the correct file path
        RepositoryPage repositoryPage = PageFactory.initElements(driver, RepositoryPage.class);
        repositoryPage.clickFileUploudButton(filePath);
        System.out.println(filePath);
    }
    @Step("Select file uploud for district")
    public void selectFileForUploudDistrictButton() throws InterruptedException, AWTException {
        String filePath = configReader.getDataPathILCE(); // Assuming this returns the correct file path
        RepositoryPage repositoryPage = PageFactory.initElements(driver, RepositoryPage.class);
        repositoryPage.clickFileUploudButton(filePath);
        System.out.println(filePath);
    }
    @Step("Select file uploud for neighbourhood")
    public void selectFileForUploudNeighbourhoodButton() throws InterruptedException, AWTException {
        String filePath = configReader.getDataPathMah(); // Assuming this returns the correct file path
        RepositoryPage repositoryPage = PageFactory.initElements(driver, RepositoryPage.class);
        repositoryPage.clickFileUploudButton(filePath);
        System.out.println(filePath);
    }

    @Step("Click continue button")
    public void clickContinueButton() throws InterruptedException {
        RepositoryPage repositoryPage = PageFactory.initElements(driver, RepositoryPage.class);
        repositoryPage.clickButton(repositoryPage.continueButton);
        Thread.sleep(5000);
    }

    @Step("Click survey data button")
    public void clickSurveyDataButton() {
        RepositoryPage repositoryPage = PageFactory.initElements(driver, RepositoryPage.class);
        repositoryPage.clickButton(repositoryPage.surveyDataButton);
    }

    @Step("Select colons for city")
    public void selectColonsForCity() throws InterruptedException {
        Thread.sleep(3000);
        RepositoryPage repositoryPage = PageFactory.initElements(driver, RepositoryPage.class);
        repositoryPage.selectColonsForCity(configReader.getDataSetIdIL(),configReader.getDataSetAliasNameIL(),configReader.getDataSetDisplayNameIL());
    }
    @Step("Select colons for district")
    public void selectColonsForDistrict() throws InterruptedException {
        Thread.sleep(3000);
        RepositoryPage repositoryPage = PageFactory.initElements(driver, RepositoryPage.class);
        repositoryPage.selectColonsForDistrict(configReader.getDataSetIdILCE(),configReader.getDataSetAliasNameILCE(),configReader.getDataSetDisplayNameILCE(), configReader.getParentColumnILCE());
    }

    @Step("Select colons for neighbourhood")
    public void selectColonsForNeighbourhood() throws InterruptedException {
        Thread.sleep(3000);
        RepositoryPage repositoryPage = PageFactory.initElements(driver, RepositoryPage.class);
        repositoryPage.selectColonsForDistrict(configReader.getDataSetIdMah(),configReader.getDataSetAliasNameMah(),configReader.getDataSetDisplayNameMah(), configReader.getParentColumnMah());
    }


}
