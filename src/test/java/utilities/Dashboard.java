package utilities;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.DashboardPage;
import utilities.Driver;

public class Dashboard {

    ConfigReader configReader = new ConfigReader();
    static WebDriver driver;
    @Step("Set up configuration2")
    public void setUpConfig() {
        configReader = new ConfigReader();
    }

    @Step("Click 'Uygulamayı Başlat' button dashboard")
    public void clickStartAppButton() throws InterruptedException {
        driver = Driver.StartBrowser(configReader.getUrl());
        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        dashboardPage.clickStartAppButton();
        Thread.sleep(2000);
    }
}
