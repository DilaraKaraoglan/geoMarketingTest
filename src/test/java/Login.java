import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.DashboardPage;
import pages.LanguagePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Login {
    ConfigReader configReader = new ConfigReader();
    static WebDriver driver;

    @Step("Set up configuration")
    public void setUpConfig() {
        configReader = new ConfigReader();
    }

    @Step("Start browser and open URL")
    public void startBrowserAndOpenURL() throws InterruptedException {
        driver = Driver.StartBrowser(configReader.getUrl());
        Thread.sleep(2000);
    }

    @Step("Login to the website")
    public void loginToWebsite() throws InterruptedException {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginToWebsite(configReader.getUsername(), configReader.getPassword());
        Thread.sleep(2000);
    }

    @Step("Click 'Uygulamayı Başlat' button")
    public void clickStartAppButton() throws InterruptedException {
        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        Thread.sleep(3000);
        dashboardPage.clickStartAppButton();
        Thread.sleep(2000);
    }
    @Step("Click 'TR' button")
    public void clicklanguageButtonFirst() throws InterruptedException {
        LanguagePage languagePage = PageFactory.initElements(driver, LanguagePage.class);
        Thread.sleep(3000);
        languagePage.clickLanguageButtonFirst();
        Thread.sleep(2000);
    }
    @Step("Change Language to ENG")
    public void clicklanguageButtonENG() throws InterruptedException {
        LanguagePage languagePage = PageFactory.initElements(driver, LanguagePage.class);
        Thread.sleep(3000);
        languagePage.clickLanguageButtonENG();
        Thread.sleep(2000);
    }
    @Step("Change Language to TR")
    public void clicklanguageButtonTR() throws InterruptedException {
        LanguagePage languagePage = PageFactory.initElements(driver, LanguagePage.class);
        Thread.sleep(3000);
        languagePage.clickLanguageButtonTR();
        Thread.sleep(2000);
    }

    @Step("Click 'ENG' button")
    public void clicklanguageButtonSecond() throws InterruptedException {
        LanguagePage languagePage = PageFactory.initElements(driver, LanguagePage.class);
        Thread.sleep(3000);
        languagePage.clickLanguageButtonSecond();
        Thread.sleep(2000);
    }
}
